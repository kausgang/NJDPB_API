package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.request_comment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestCommentMapper {

    RequestCommentResponseDTO toResponseDTO(RequestComment requestComment);

    List<RequestCommentResponseDTO> toResponseDTOList(List<RequestComment> requestCommentList);
}