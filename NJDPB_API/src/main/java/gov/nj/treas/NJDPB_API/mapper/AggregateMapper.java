package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(
            List<MemberApplicationResponseDTO> member_application
    ){

        AggregateResponseDTO dto = new AggregateResponseDTO();
        dto.setMember_application(member_application);

        return dto;

    };
}
