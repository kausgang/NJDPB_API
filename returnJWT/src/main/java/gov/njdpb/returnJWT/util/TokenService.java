package gov.njdpb.returnJWT.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenService {

    @Value("${CONNECT_SECRET}")
    private String CONNECT_SECRET;

    @Value("${WIDGET_ID}")
    private String WIDGET_ID;

    @Value("${JWT_EXP_DELTA_SECONDS}")
    private int JWT_EXP_DELTA_SECONDS;

    public String returnToken(String firstName, String lastName, String email) {





        Algorithm algorithm = Algorithm.HMAC256(CONNECT_SECRET);

        Date now = new Date();

        Date issuedAt = new Date(now.getTime() - 50 * 1000L);
        Date expiresAt = new Date(issuedAt.getTime() + JWT_EXP_DELTA_SECONDS * 1000L);

        // attributes map (nested)
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("FirstName",firstName);
        attributes.put("LastName",lastName);
        attributes.put("Email",email);
//        attributes.put("customerName", "Sukumar");
//        attributes.put("accountID", "123456789");
//        attributes.put("email", "jane@example.com");
//        attributes.put("sessionID", "portal-session-xyz");

        // build token
        String token = JWT.create()
                .withHeader(Map.of("typ", "JWT", "alg", "HS256"))
                .withSubject(WIDGET_ID)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withClaim("attributes", attributes)
                .sign(algorithm);

        return token;
    }
}