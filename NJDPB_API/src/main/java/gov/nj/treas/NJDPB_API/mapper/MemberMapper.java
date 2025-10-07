package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toEntity(MemberRequestDTO memberRequestDTO);

    MemberResponseDTO toResponseDTO(Member member);

    List<MemberResponseDTO> toResponseDTOList(List<Member> members);
}
