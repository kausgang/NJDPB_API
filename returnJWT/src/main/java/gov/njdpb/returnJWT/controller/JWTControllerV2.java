package gov.njdpb.returnJWT.controller;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;
import gov.njdpb.returnJWT.dto.ResponseV2DTO;
import gov.njdpb.returnJWT.service.intrface.ReturnJWT;
import gov.njdpb.returnJWT.service.intrface.ReturnJWTV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v2")
public class JWTControllerV2 {


    private final ReturnJWTV2 returnJWT;

    @PostMapping("/getJWT")
    public ResponseEntity<ResponseV2DTO> getJWT(@RequestBody RequestDTO requestDTO){

        log.debug("Input received - {}",requestDTO);

        ResponseV2DTO response = returnJWT.provideJWT(requestDTO);
        return ResponseEntity.ok(response);
    }
}
