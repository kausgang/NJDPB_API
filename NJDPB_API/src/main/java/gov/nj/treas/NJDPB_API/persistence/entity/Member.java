package gov.nj.treas.NJDPB_API.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
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
    private Integer request_count;
    private String chapter_flag;
    private String former_name;
    private String member_tier;


}