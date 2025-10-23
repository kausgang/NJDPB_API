package gov.nj.treas.NJDPB_API.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "LETTER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Letter {

    @Id
    private Integer letter_id;
    private Integer  letter_type;
    private String ssn;




}
