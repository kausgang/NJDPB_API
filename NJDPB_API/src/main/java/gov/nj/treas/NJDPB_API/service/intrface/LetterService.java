package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;

import java.util.List;

public interface LetterService {

//    List<MemberResponseDTO> getMembersBySsn(MemberRequestDTO memberRequestDTO);
List<LetterResponseDTO> getLetterBySsn(AggregateRequestDTO aggregateRequestDTO);
}
