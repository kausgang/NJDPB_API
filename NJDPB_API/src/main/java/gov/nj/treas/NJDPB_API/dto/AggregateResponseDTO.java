package gov.nj.treas.NJDPB_API.dto;

import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.requestComment.RequestCommentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateResponseDTO implements Serializable {

    private List<MemberResponseDTO> members;
    private List<ProcessedResponseDTO> processed_request;
    private List<CalculationResponseDTO> calculations;
    private List<RequestCommentResponseDTO> request_comments;
    private List<LetterResponseDTO> letters;
}
