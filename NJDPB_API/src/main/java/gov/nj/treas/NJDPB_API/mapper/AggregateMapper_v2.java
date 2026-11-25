package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.*;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper_v2 {

//    default AggregateResponseDTO toAggregateResponseDto(
//            List<MemberApplicationResponseDTO> member_application,
//            List<LetterResponseDTO> letter,
//            List<CommentResponseDTO> comment
//    ){


    default AggregateResponseDTO_v2 toAggregateResponseDto_v2(
            List<MemberApplicationResponseDTO> member_application,
            List<LetterResponseDTO> letter,
            List<CommentResponseDTO> comment,
            MSSChecklistResponseDTO mssChecklistResponseDTO
    ){

        AggregateResponseDTO_v2 dto = new AggregateResponseDTO_v2();

        dto.setMember_applications(member_application);
        dto.setLetters(letter);
        dto.setComments(comment);

        dto.setMssChecklist(mssChecklistResponseDTO);


        return dto;

    };
}
