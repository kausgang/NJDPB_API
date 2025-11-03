package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.annotation.SimulateDelay;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.ErrorResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.exception.DbTimeoutException;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberService;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    @Cacheable(value = "membersBySsn", key = "#memberRequestDTO.ssn")
    @Async("taskExecutor") // Specify the executor bean name
    @Retry(name = "DORES_DB")
    @TimeLimiter(name = "DORES_DB", fallbackMethod = "fallBack_getMembersBySsn")
//    @SimulateDelay(millis = 7000)
    public CompletableFuture<List<MemberResponseDTO>> getMembersBySsn(AggregateRequestDTO memberRequestDTO) {


        String ssn = memberRequestDTO.getSsn();
        List<Member> members = memberRepository.findBySsn(ssn);
        if(members.isEmpty()) throw new RecordNotFoundException("MEMBER_SERVICE - Record Not Fount");
        List<MemberResponseDTO> memberResponseDTOList = memberMapper.toResponseDTOList(members);
        return CompletableFuture.completedFuture(memberResponseDTOList);

    }

    public CompletableFuture<List<MemberResponseDTO>> fallBack_getMembersBySsn(AggregateRequestDTO memberRequestDTO, Throwable t) throws TimeoutException {

        log.warn("Fallback triggered for SSN due to: {}",t.toString());

        throw new DbTimeoutException("DB operation timeout");
        // You can return an empty list or a default response
//        return CompletableFuture.completedFuture(Collections.emptyList());
    }
}
