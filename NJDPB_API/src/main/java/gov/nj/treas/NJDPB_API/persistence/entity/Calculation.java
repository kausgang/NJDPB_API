package gov.nj.treas.NJDPB_API.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CALCULATION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {


    @Id
    private String ssn;
    private Integer request_id;



    //Done by Itunuoluwa for dbo.calculation
    private String member_Num;
    private String calcby_userid;
    private String purchase_abbreviation;
    private BigDecimal purchase_Length;
    private String buy_pay_schedule;
    private String reason_for_lumpsum_letter;
    private LocalDateTime request_date;
    private BigDecimal lump_sum_amount;
    private Integer num_of_payments;
    private BigDecimal single_payment_amount;
    private BigDecimal balance;
    private String comment1;
    private String pay_sched;

}
