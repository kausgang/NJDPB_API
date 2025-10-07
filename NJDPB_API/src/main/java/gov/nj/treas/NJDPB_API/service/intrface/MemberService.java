package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;

import java.util.List;

public interface MemberService {

    List<MemberResponseDTO> getMembersBySsn(MemberRequestDTO memberRequestDTO);
}
