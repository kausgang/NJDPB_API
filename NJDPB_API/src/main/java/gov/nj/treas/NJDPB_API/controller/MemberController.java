package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.MemberServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Tag(name = "Member")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberServiceimpl;



    @Operation(
            summary = "Find members by SSN",
            description = "Retrieves member information based on provided SSN number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved member information",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MemberResponseDTO.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request - invalid SSN or processing error",
                            content = @Content
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Member SSN information",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MemberRequestDTO.class)
                    )
            )
    )
    @PostMapping("/find_by_ssn")
    public ResponseEntity<?> postMemberBySSN(@RequestBody MemberRequestDTO memberRequestDTO){

        try{
            List<MemberResponseDTO> members = memberServiceimpl.getMembersBySsn(memberRequestDTO);
            return new ResponseEntity<>(members,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
