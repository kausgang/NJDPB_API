package gov.nj.treas.NJDPB_API.dto.member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDTO {

    private String ssn;
    private String member_num;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private LocalDateTime birth_date;
    private LocalDateTime termination_date;
    private LocalDateTime retirement_date;
    private LocalDateTime enrollment_Date;
    private String veterans_flag;
    private String calcby;
    private String former_name;
}