package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProcessedRequestServiceImplTest {

    @Mock
    ProcessedRequestRepository processedRequestRepository;

    @Mock
    ProcessedRequestMapper processedRequestMapper;

    @InjectMocks
    ProcessedRequestServiceImpl processedRequestService;


    private ProcessedRequestDTO processedRequestDTO;
    private ProcessedRequest processedRequest;
    private ProcessedResponseDTO processedResponseDTO;
//    private List<ProcessedResponseDTO> processedResponseDTOList;

    @BeforeEach
    void setUp() {

         processedRequestDTO = ProcessedRequestDTO.builder()
                .ssn("123456789").build();

        processedRequest = ProcessedRequest.builder()
                .ssn("123456789")
                .request_id(12)
                .build();

        processedResponseDTO = ProcessedResponseDTO.builder()
                .ssn("123456789")
                .request_id(12)
                .build();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProcessedRequestBySsn() {

        List<ProcessedRequest> mockProcessedRequests = List.of(processedRequest);
        List<ProcessedResponseDTO> expectedProcessedResponseDTO = List.of(processedResponseDTO);

//        when repository findBySsn is called - return a list of entity
//        Mockito.when(processedRequestRepository.findBySsn("123456789"))
//                .thenReturn(Collections.singletonList(processedRequest));
        Mockito.when(processedRequestRepository.findBySsn("123456789"))
                .thenReturn(mockProcessedRequests);


//        when mapper.toResponseDTOlist is called, return list of responsedto
//        Mockito.when(processedRequestMapper.toResponseDTOList(Collections.singletonList(processedRequest)))
//                .thenReturn(Collections.singletonList(processedResponseDTO));
        Mockito.when(processedRequestMapper.toResponseDTOList(Collections.singletonList(processedRequest)))
                .thenReturn(expectedProcessedResponseDTO);

        List<ProcessedResponseDTO> pr = processedRequestService.getProcessedRequestBySsn(processedRequestDTO);

//        Assertions.assertThat(pr).isNotEmpty();
        Assertions.assertNotNull(pr);
        Assertions.assertEquals(1,pr.size());
        Assertions.assertEquals(expectedProcessedResponseDTO.getFirst().getSsn(),pr.getFirst().getSsn());

    }
}