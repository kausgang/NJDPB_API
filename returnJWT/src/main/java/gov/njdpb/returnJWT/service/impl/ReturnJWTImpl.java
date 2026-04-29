package gov.njdpb.returnJWT.service.impl;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;
import gov.njdpb.returnJWT.service.intrface.ReturnJWT;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class ReturnJWTImpl implements ReturnJWT {
    @Override
    public ResponseDTO provideJWT(RequestDTO requestDTO) {
        return ResponseDTO.builder().jwt("kaustav").build();
    }
}
