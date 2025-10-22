package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.requestromment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Calculation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

//    default AggregateResponseDTO toAggregateResponseDto(List<MemberResponseDTO> members, List<ProcessedResponseDTO> processedRequests){
default AggregateResponseDTO toAggregateResponseDto(
        List<MemberResponseDTO> members,
        List<ProcessedResponseDTO> processedRequests,
        List<CalculationResponseDTO> calculations,
        List<RequestCommentResponseDTO> requestComment

){


        AggregateResponseDTO dto = new AggregateResponseDTO();
        dto.setMembers(members);
        dto.setProcessed_responses(processedRequests);
        dto.setCalculations(calculations);
        dto.setRequest_comment(requestComment);

        return dto;

    };
}
