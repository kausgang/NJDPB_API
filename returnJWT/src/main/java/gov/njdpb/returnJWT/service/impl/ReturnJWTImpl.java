package gov.njdpb.returnJWT.service.impl;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;
import gov.njdpb.returnJWT.service.intrface.ReturnJWT;
import gov.njdpb.returnJWT.util.TokenService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class ReturnJWTImpl implements ReturnJWT {

    @Autowired
    TokenService tokenService;


    private String firstName;
    private String lastName;
    private String email;

    @Override
    public ResponseDTO provideJWT(RequestDTO requestDTO) {

        log.info("Processing JWT generation");

        log.debug("Extracting fields from RequestDTO");

        firstName = requestDTO.getFirstName();
        lastName = requestDTO.getLastName();
        email = requestDTO.getEmail();

        log.debug("FirstName: {}", firstName);
        log.debug("LastName: {}", lastName);
        log.debug("Email: {}", email);

        try {
            String jwt = tokenService.returnToken(firstName,lastName,email);

            log.info("TokenService returned a JWT successfully");
            log.debug("Generated JWT: {}", jwt);

            return ResponseDTO.builder()
                    .jwt(jwt)
                    .build();

        } catch (Exception e) {

            log.error("Error while generating JWT in ReturnJWTImpl", e);
            throw new RuntimeException(e);
        }


    }
}
