package gov.nj.treas.NJDPB_API.mapper;

import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import gov.nj.treas.NJDPB_API.dto.request_comment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.dto.request_letter.RequestLetterResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AggregateMapper {

    default AggregateResponseDTO toAggregateResponseDto(
            List<MemberResponseDTO> members,
            List<ProcessedRequestResponseDTO> processed_request,
            List<RequestCommentResponseDTO> request_comment,
            List<RequestLetterResponseDTO> request_letter
    ){

        AggregateResponseDTO dto = new AggregateResponseDTO();

        dto.setMembers(members);
        dto.setProcessed_request(processed_request);
        dto.setRequest_comment(request_comment);
        dto.setRequest_letter(request_letter);

        return dto;

    };
}