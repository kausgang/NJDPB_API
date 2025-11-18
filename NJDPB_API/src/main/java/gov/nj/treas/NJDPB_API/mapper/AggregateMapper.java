package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.CommentResponseDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(
            List<MemberApplicationResponseDTO> member_application,
            List<LetterResponseDTO> letter,
            List<CommentResponseDTO> comment
    ){

        AggregateResponseDTO dto = new AggregateResponseDTO();
        dto.setMember_applications(member_application);
        dto.setLetters(letter);
        dto.setComments(comment);

        return dto;

    };
}
