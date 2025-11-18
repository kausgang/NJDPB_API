package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.CommentResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentResponseDTO toResponse(Comment comment);
    List<CommentResponseDTO> toResponseList(List<Comment> comments);
}
