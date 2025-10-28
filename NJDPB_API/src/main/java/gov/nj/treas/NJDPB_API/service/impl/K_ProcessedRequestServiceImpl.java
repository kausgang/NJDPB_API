package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.K_ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.K_ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.K_ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.service.intrface.K_ProcessedRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class K_ProcessedRequestServiceImpl implements K_ProcessedRequestService {

//    @Autowired
//    ProcessedRequestRepository processedRequestRepository;
//
//    @Autowired
    private final K_ProcessedRequestMapper k_processedRequestMapper;

//    private final ProcessedRequestRepository processedRequestRepository;
//    private final ProcessedRequestMapper processedRequestMapper;

    private final K_ProcessedRequestRepository k_processedRequestRepository;

    @Override
//    @Cacheable(value="processedResponse",key = "#processedRequestDTO.ssn")
    public List<K_ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO) {

        String ssn = processedRequestDTO.getSsn();

//        List<ProcessedRequest> processedRequests = processedRequestRepository.findBySsn(ssn);
        List<K_ProcessedRequest> processedRequests = k_processedRequestRepository.findByProcessedRequestIdSsn(ssn);

        log.info("processed requests for ssn {} is {}",ssn,processedRequests);

        if(processedRequests.isEmpty()) throw new RecordNotFoundException("PROCESSED_REQUEST_SERVICE - Record Not Fount");

        return k_processedRequestMapper.toResponseDTOList(processedRequests);

    }
}
