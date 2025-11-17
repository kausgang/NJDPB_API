package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.LetterMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Letter;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import gov.nj.treas.NJDPB_API.persistence.repository.LetterRepository;
import gov.nj.treas.NJDPB_API.service.intrface.LetterService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;



@Service
@Data
@Slf4j
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {

    private final LetterRepository letterRepository;
    private final LetterMapper letterMapper;


    @Override
    public CompletableFuture<List<LetterResponseDTO>> getLetterBySsn(AggregateRequestDTO aggregateRequestDTO) {

        try {
            String ssn = aggregateRequestDTO.getSsn();

            List<Letter> letterList = letterRepository.findBySsn(ssn);

            if(letterList.isEmpty()) throw new RecordNotFoundException("LETTER - Record not found");

            List<LetterResponseDTO> letterResponseDTOList = letterMapper.toResponseDTOList(letterList);

            return CompletableFuture.completedFuture(letterResponseDTOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
