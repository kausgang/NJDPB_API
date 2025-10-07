package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.member.MemberRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.service.intrface.MemberService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberMapper memberMapper;



    @Override
    public List<MemberResponseDTO> getMembersBySsn(MemberRequestDTO memberRequestDTO) {

        String ssn = memberRequestDTO.getSsn();

        log.debug("ssn for member service is - {}", ssn);
        List<Member> members = memberRepository.findBySsn(ssn);
        log.debug("members returned by repository = {}",members);


//        return List.of();

        return memberMapper.toResponseDTOList(members);
    }
}
