package gov.nj.treas.NJDPB_API.dto;

import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateResponseDTO {

    private List<MemberResponseDTO> members;
    private List<ProcessedResponseDTO> processed_responses;
}
