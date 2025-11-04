package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.service.intrface.ProcessedRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProcessedRequestServiceImpl implements ProcessedRequestService {

    private final ProcessedRequestRepository processedRequestRepository;
    private final ProcessedRequestMapper processedRequestMapper;

    @Override
    public CompletableFuture<List<ProcessedRequestResponseDTO>> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO) {

        String ssn = processedRequestDTO.getSsn();

        List<ProcessedRequest> processedRequests = processedRequestRepository.findByProcessedRequestIdSsn(ssn);

        if(processedRequests.isEmpty()) throw new RecordNotFoundException("PROCESSED_REQUEST_SERVICE - Record Not Fount");

        List<ProcessedRequestResponseDTO> processedResponseDTOList = processedRequestMapper.toResponseDTOList(processedRequests);

        return CompletableFuture.completedFuture(processedResponseDTOList);

    }
}