package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.service.intrface.ProcessedRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessedRequestServiceImpl implements ProcessedRequestService {

    @Autowired
    ProcessedRequestRepository processedRequestRepository;

    @Autowired
    ProcessedRequestMapper processedRequestMapper;


    @Override
    @Cacheable(value="processedResponse",key = "#processedRequestDTO.ssn")
    public List<ProcessedResponseDTO> getProcessedRequestBySsn(AggregateRequestDTO processedRequestDTO) {

        String ssn = processedRequestDTO.getSsn();

        List<ProcessedRequest> processedRequests = processedRequestRepository.findBySsn(ssn);

        if(processedRequests.isEmpty()) throw new RecordNotFoundException("PROCESSED_REQUEST_SERVICE - Record Not Fount");

        return processedRequestMapper.toResponseDTOList(processedRequests);

    }
}
