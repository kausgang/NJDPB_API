package gov.nj.treas.NJDPB_API.dto;

import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
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

    private List<MemberApplicationResponseDTO> member_application;

}
