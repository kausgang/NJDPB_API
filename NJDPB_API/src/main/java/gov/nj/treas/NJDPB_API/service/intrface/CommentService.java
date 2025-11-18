package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.CommentResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CommentService {

    CompletableFuture<List<CommentResponseDTO>> getCommentBySsn(AggregateRequestDTO aggregateRequestDTO);
}
