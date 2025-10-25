package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private MemberMapper memberMapper;

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    @Cacheable(value = "membersBySsn", key = "#memberRequestDTO.ssn")
    public List<MemberResponseDTO> getMembersBySsn(AggregateRequestDTO memberRequestDTO) {

        String ssn = memberRequestDTO.getSsn();

        log.debug("ssn for member service is - {}", ssn);
        List<Member> members = memberRepository.findBySsn(ssn);
        log.debug("members returned by repository = {}",members);

        if(members.isEmpty()) throw new RecordNotFoundException("MEMBER_SERVICE - Record Not Fount");


        return memberMapper.toResponseDTOList(members);
    }
}
