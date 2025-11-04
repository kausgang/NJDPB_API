package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.request_comment.RequestCommentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface RequestCommentService {

    CompletableFuture<List<RequestCommentResponseDTO>> getRequestCommentBySsn(AggregateRequestDTO aggregateRequestDTO);
}