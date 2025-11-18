package gov.nj.treas.NJDPB_API.dto.member_application;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberApplicationResponseDTO {


    private Integer idn_member_num;
    private String ssnMember;


    private String desc_curr_operation;
    //    private String desc_type_ret;
    private String dte_app_received;
    private String dte_cert_received;
    private String dte_enrollment;
    private String dte_retirement;
    //    private LocalDateTime dte_Service_Format1;
//    private LocalDateTime dte_Service_Format2;
//    private Boolean flg_Mss_Option;
    private String nme_entered_by;
    private String nme_member;
    private String nme_Tech;
//    private LocalDateTime dte_service_format3;
//    private Integer num_total_hb_serv_mos3;
//    private Integer num_total_od_serv_mos3;

}
