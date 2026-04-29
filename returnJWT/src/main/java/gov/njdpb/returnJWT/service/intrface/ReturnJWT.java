package gov.njdpb.returnJWT.service.intrface;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;

public interface ReturnJWT {

    ResponseDTO provideJWT(RequestDTO requestDTO);
}
