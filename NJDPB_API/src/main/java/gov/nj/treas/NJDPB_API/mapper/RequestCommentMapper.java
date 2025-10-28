package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.requestComment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestCommentMapper {

//    Calculation toEntity(rocessedRequestDTO processedRequestDTO);

    RequestCommentResponseDTO toResponseDTO(RequestCommentMapper requestComment);

    List<RequestCommentResponseDTO> toResponseDTOList(List<RequestComment> requestCommentList);
}
