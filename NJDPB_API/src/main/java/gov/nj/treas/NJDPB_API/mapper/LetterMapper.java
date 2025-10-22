package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LetterMapper {

//    Member toEntity(MemberRequestDTO memberRequestDTO);

    LetterResponseDTO toResponseDTO(Letter letter);

    List<LetterResponseDTO> toResponseDTOList(List<Letter> letter);
}
