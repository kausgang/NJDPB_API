package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.annotation.DebugLogging;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    @Async("taskExecutor") // Specify the executor bean name
    @DebugLogging
    public CompletableFuture<List<MemberResponseDTO>> getMembersBySsn(AggregateRequestDTO memberRequestDTO) {


        String ssn = memberRequestDTO.getSsn();
        List<Member> members = memberRepository.findBySsn(ssn);

        if(members.isEmpty()) throw new RecordNotFoundException("MEMBER_SERVICE - Record Not Fount");

        List<MemberResponseDTO> memberResponseDTOList = memberMapper.toResponseDTOList(members);
        return CompletableFuture.completedFuture(memberResponseDTOList);

    }

}