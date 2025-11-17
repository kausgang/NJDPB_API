package gov.nj.treas.NJDPB_API.dto.member_application;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberApplicationResponseDTO {


    private Integer idn_member_num;
    private String ssnNumber;
}
