package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(
            List<MemberResponseDTO> members,
            List<ProcessedRequestResponseDTO> processed_request
    ){

        AggregateResponseDTO dto = new AggregateResponseDTO();

        dto.setMembers(members);
        dto.setProceed_request(processed_request);

        return dto;

    };
}