package gov.nj.treas.NJDPB_API.service.impl;


import gov.nj.treas.NJDPB_API.dto.LetterRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.LetterMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import gov.nj.treas.NJDPB_API.persistence.repository.LetterRepository;
import gov.nj.treas.NJDPB_API.service.intrface.LetterService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Data
@Slf4j
public class LetterServiceImpl implements LetterService {


    private final LetterMapper letterMapper;
    private final LetterRepository letterRepository;


    @Override
    public List<LetterResponseDTO> getLetterBySSN(LetterRequestDTO letterRequestDTO) {

        String ssn = letterRequestDTO.getSsn();

        log.debug("SSN is - {}",ssn);

        List<Letter> letters = letterRepository.findBySsn(ssn);

        log.debug("letters = {}",letters);

//        return letters.stream()
//                .map(letterMapper::toResponseDTO) // Renamed to match your mapper
//                .collect(Collectors.toList());
        return letterMapper.toResponseDTOList(letters);
    }

}
