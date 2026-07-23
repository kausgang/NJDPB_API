package gov.njdpb.returnJWT.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenService {

    @Value("${CONNECT_SECRET}")
    private String CONNECT_SECRET;

    @Value("${WIDGET_ID}")
    private String WIDGET_ID;

    @Value("${JWT_EXP_DELTA_SECONDS}")
    private int JWT_EXP_DELTA_SECONDS;

    public String returnToken(String firstName, String lastName, String email) {



        log.info("Starting JWT token construction");

        log.debug("Using configuration:");
        log.debug("WIDGET_ID: {}", WIDGET_ID);
        log.debug("JWT_EXP_DELTA_SECONDS: {}", JWT_EXP_DELTA_SECONDS);

        try {
            Algorithm algorithm = Algorithm.HMAC256(CONNECT_SECRET);

            log.debug("Algorithm initialized using HMAC256");

            Date now = new Date();

            Date issuedAt = new Date(now.getTime() - 50 * 1000L);
            Date expiresAt = new Date(issuedAt.getTime() + JWT_EXP_DELTA_SECONDS * 1000L);

            log.debug("IssuedAt: {}", issuedAt);
            log.debug("ExpiresAt: {}", expiresAt);

            // attributes map (nested)
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("FirstName",firstName);
            attributes.put("LastName",lastName);
            attributes.put("Email",email);

            log.debug("Attributes map created: {}", attributes);

            // build token
            String token = JWT.create()
                    .withHeader(Map.of("typ", "JWT", "alg", "HS256"))
                    .withSubject(WIDGET_ID)
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(expiresAt)
                    .withClaim("attributes", attributes)
                    .sign(algorithm);

            log.info("JWT token generation complete");

            return token;

        }  catch (Exception  e) {

            log.error("Error while constructing JWT", e);
            throw new RuntimeException(e);
        }


    }
}