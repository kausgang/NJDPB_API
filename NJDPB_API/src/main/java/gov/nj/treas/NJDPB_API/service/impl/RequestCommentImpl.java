package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.annotation.DebugLogging;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.request_comment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.RequestCommentMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import gov.nj.treas.NJDPB_API.persistence.repository.RequestCommentRepository;
import gov.nj.treas.NJDPB_API.service.intrface.RequestCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class RequestCommentImpl implements RequestCommentService {


    private final RequestCommentRepository requestCommentRepository;
    private final RequestCommentMapper requestCommentMapper;

    @Override
    @Async("taskExecutor") // Specify the executor bean name
    @DebugLogging
    public CompletableFuture<List<RequestCommentResponseDTO>> getRequestCommentBySsn(AggregateRequestDTO aggregateRequestDTO) {

        String ssn = aggregateRequestDTO.getSsn();

        List<RequestComment> requestComments = requestCommentRepository.findBySsn(ssn);

//        if(requestComments.isEmpty()) throw new RecordNotFoundException("REQUEST_COMMENT_SERVICE - Record Not Fount");

        return CompletableFuture.completedFuture(requestCommentMapper.toResponseDTOList(requestComments));

    }
}