package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.MemberServiceImpl;
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
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberServiceImpl memberServiceimpl;

//    @Autowired
//    private MemberRequestDTO memberRequestDTO;

    @PostMapping("/member")
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
