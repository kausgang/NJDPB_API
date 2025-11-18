package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.CommentResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.CommentMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Comment;
import gov.nj.treas.NJDPB_API.persistence.repository.CommentRepository;
import gov.nj.treas.NJDPB_API.service.intrface.CommentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    @Override
    public CompletableFuture<List<CommentResponseDTO>> getCommentBySsn(AggregateRequestDTO aggregateRequestDTO) {

        try {
            String ssn = aggregateRequestDTO.getSsn();

            List<Comment> commentList = commentRepository.findBySsn(ssn);

            if(commentList.isEmpty()) throw new RecordNotFoundException("COMMENT - Record not found");

            List<CommentResponseDTO> commentResponseDTOList = commentMapper.toResponseList(commentList);

            return CompletableFuture.completedFuture(commentResponseDTOList);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
