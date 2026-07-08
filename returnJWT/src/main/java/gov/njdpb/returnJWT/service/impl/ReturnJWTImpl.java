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


        firstName = requestDTO.getFirstName();
        lastName = requestDTO.getLastName();
        email = requestDTO.getEmail();

        String jwt = tokenService.returnToken(firstName,lastName,email);

        log.debug("Service returned - {}",jwt);

        return ResponseDTO.builder()
                .jwt(jwt)
                .build();


    }
}
