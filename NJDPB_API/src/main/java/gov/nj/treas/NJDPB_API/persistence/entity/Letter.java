package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "letter")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Letter {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String letter_id;
    private String ssn;
//    private Long IDN_MEMBER_NUM;
//    private String FIELD1;
}
