package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MemberService {

    CompletableFuture<List<MemberResponseDTO>> getMembersBySsn(AggregateRequestDTO memberRequestDTO);
}