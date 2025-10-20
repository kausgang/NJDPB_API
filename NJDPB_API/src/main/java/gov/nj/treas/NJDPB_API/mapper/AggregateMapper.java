package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(List<MemberResponseDTO> members, List<ProcessedResponseDTO> processedRequests){


        AggregateResponseDTO dto = new AggregateResponseDTO();
        dto.setMembers(members);
        dto.setProcessed_responses(processedRequests);
        return dto;

    };
}
