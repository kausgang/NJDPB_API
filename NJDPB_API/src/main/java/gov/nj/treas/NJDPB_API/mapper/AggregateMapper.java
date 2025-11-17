package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(
            List<MemberApplicationResponseDTO> member_application,
            List<LetterResponseDTO> letter
    ){

        AggregateResponseDTO dto = new AggregateResponseDTO();
        dto.setMember_applications(member_application);
        dto.setLetters(letter);

        return dto;

    };
}
