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

}
