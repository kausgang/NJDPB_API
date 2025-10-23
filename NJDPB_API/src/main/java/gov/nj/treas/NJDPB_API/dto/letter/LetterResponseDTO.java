package gov.nj.treas.NJDPB_API.dto.letter;


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
public class LetterResponseDTO implements Serializable {

    private Integer letter_id;
//    private Integer letter_type;
    private String ssn;
//
//
////   //Done by Itunuoluwa  dbo.Letter
////
//
//    private String mem_id;
    private Integer req_num;
//    private String user_id;
//    private String addr_name;
//    private String addr_1;
//    private String addr_2;
//    private String addr_3;
//    private String city;
//    private String state;
//    private String zip;
//    private String mem_name;
//    private String mem_addr_1;
//    private String mem_addr_2;
//    private String mem_addr_3;
//    private String mem_city;
//    private String mem_state;
//    private String mem_zip;


}
