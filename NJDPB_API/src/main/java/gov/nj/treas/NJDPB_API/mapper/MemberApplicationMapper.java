package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberApplicationMapper {


    MemberApplicationResponseDTO toResponseDTO(MemberApplication memberApplication);
    List<MemberApplicationResponseDTO> toResponseDTOList(List<MemberApplication> members);
}
