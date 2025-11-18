package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_application")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberApplication {

    @Id
    private Integer idn_member_num;

    @Column(name = "ssn_member")
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
