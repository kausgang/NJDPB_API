package gov.njdpb.returnJWT.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseV2DTO {

    private String jwt;
    private String chatHours;

}
