package gov.njdpb.returnJWT.controller;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;
import gov.njdpb.returnJWT.service.intrface.ReturnJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class JWTController {


    private final ReturnJWT returnJWT;

    @PostMapping("/getJWT")
    public ResponseEntity<ResponseDTO> getJWT(@RequestBody RequestDTO requestDTO){

        log.debug("Input received - {}",requestDTO);

        ResponseDTO response = returnJWT.provideJWT(requestDTO);
        return ResponseEntity.ok(response);
    }
}
