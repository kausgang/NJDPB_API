package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mss_checklist")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MSSChecklist {

    @Id
//    @Column(name = "idn_member_num")
    private Integer idn_member_num;

//    @Column(name = "desc_type_ret")
    private String desc_type_ret;

}
