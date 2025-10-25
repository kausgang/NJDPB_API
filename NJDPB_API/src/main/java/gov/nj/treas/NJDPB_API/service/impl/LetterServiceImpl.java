package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.LetterMapper;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.LetterRepository;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.service.intrface.LetterService;
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
public class LetterServiceImpl implements LetterService {

//    @Autowired
//    private LetterRepository letterRepository;
//    @Autowired
//    private LetterMapper letterMapper;

    private final LetterRepository letterRepository;
    private final LetterMapper letterMapper;


    @Override
    @Cacheable(value = "letterBySsn", key = "#aggregateRequestDTO.ssn")
    public List<LetterResponseDTO> getLetterBySsn(AggregateRequestDTO aggregateRequestDTO) {

        String ssn = aggregateRequestDTO.getSsn();


        // Format the SSN to match the database format "xxx-xx-xxxx"
        String hyphenatedSsn = String.format("%s-%s-%s",
                ssn.substring(0, 3),
                ssn.substring(3, 5),
                ssn.substring(5, 9));

//        log.info("LETTER_SERVICE - reformatted SSN - {}",hyphenatedSsn);

        log.debug("ssn for letter service is - {}", ssn);
        List<Letter> letters = letterRepository.findBySsn(hyphenatedSsn);
        log.debug("letter returned by repository = {}",letters);

        if(letters.isEmpty()) throw new RecordNotFoundException("LETTER_SERVICE - Record Not Fount");


        return letterMapper.toResponseDTOList(letters);
    }
}
