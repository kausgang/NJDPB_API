package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.requestromment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.RequestCommentMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import gov.nj.treas.NJDPB_API.persistence.repository.RequestCommentRepository;
import gov.nj.treas.NJDPB_API.service.intrface.CalculationService;
import gov.nj.treas.NJDPB_API.service.intrface.RequestCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestCommentImpl implements RequestCommentService {

//    @Autowired
//    RequestCommentRepository requestCommentRepository;
//
//    @Autowired
//    RequestCommentMapper requestCommentMapper;

    private final RequestCommentRepository requestCommentRepository;
    private final RequestCommentMapper requestCommentMapper;

    @Override
    @Cacheable(value="requestCommentResponse",key = "#aggregateRequestDTO.ssn")
    public List<RequestCommentResponseDTO> getRequestCommentBySsn(AggregateRequestDTO aggregateRequestDTO) {

        String ssn = aggregateRequestDTO.getSsn();

        List<RequestComment> requestComments = requestCommentRepository.findBySsn(ssn);

        if(requestComments.isEmpty()) throw new RecordNotFoundException("REQUEST_COMMENT_SERVICE - Record Not Fount");

        return requestCommentMapper.toResponseDTOList(requestComments);

    }
}
