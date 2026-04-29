package gov.njdpb.returnJWT.service.impl;

import gov.njdpb.returnJWT.dto.RequestDTO;
import gov.njdpb.returnJWT.dto.ResponseDTO;
import gov.njdpb.returnJWT.service.intrface.ReturnJWT;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReturnJWTImplTest {

    private RequestDTO requestDTO;
    private ResponseDTO responseDTO;
//    private ReturnJWTImpl returnJWTImpl;
    private ReturnJWT returnJWT;



    @BeforeEach
    void setUp() {

        requestDTO = RequestDTO.builder()
                .firstName("Mavisha").build();

        responseDTO = ResponseDTO.builder()
                .jwt("Kaustav").build();

        returnJWT = new ReturnJWTImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void returnJWT() {


        ResponseDTO response = returnJWT.provideJWT(requestDTO);

        assertNotNull(response);
//        assertEquals("kaustav", response.getJwt());


    }
}