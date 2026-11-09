package gov.njdpb.returnJWT.service.intrface;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseV2DTO;

public interface ReturnJWTV2 {
    ResponseV2DTO provideJWT(RequestDTO requestDTO);
}
