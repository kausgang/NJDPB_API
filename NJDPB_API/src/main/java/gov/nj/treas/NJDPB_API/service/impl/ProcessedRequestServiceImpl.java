package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.service.intrface.ProcessedRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessedRequestServiceImpl implements ProcessedRequestService {

    private final ProcessedRequestRepository processedRequestRepository;
    private final ProcessedRequestMapper processedRequestMapper;

    @Override
    @Cacheable(value="processedResponse",key = "#processedRequestDTO.ssn")
    public List<ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO) {

        String ssn = processedRequestDTO.getSsn();

        List<ProcessedRequest> processedRequests = processedRequestRepository.findByProcessedRequestIdSsn(ssn);

        if(processedRequests.isEmpty()) throw new RecordNotFoundException("PROCESSED_REQUEST_SERVICE - Record Not Fount");

        return processedRequestMapper.toResponseDTOList(processedRequests);

    }
}
