package gov.nj.treas.NJDPB_API.dto;

import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
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
    private List<ProcessedRequestResponseDTO> proceed_request;

}