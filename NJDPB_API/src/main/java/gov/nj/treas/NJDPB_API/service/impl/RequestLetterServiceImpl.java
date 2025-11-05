package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.request_letter.RequestLetterResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.RequestLetterMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.request_letter.RequestLetter;
import gov.nj.treas.NJDPB_API.persistence.repository.RequestLetterRepository;
import gov.nj.treas.NJDPB_API.service.intrface.RequestLetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestLetterServiceImpl implements RequestLetterService {


    private final RequestLetterRepository requestLetterRepository;
    private final RequestLetterMapper requestLetterMapper;


    @Override
    public CompletableFuture<List<RequestLetterResponseDTO>> getRequestLetterBySsn(AggregateRequestDTO aggregateRequestDTO) {

        String ssn = aggregateRequestDTO.getSsn();

        List<RequestLetter> requestLetters = requestLetterRepository.findByRequestLetterIdSsn(ssn);

        if(requestLetters.isEmpty()) throw new RecordNotFoundException("REQUEST_LETTER_SERVICE - Record Not Found ");

        List<RequestLetterResponseDTO> requestLetterResponseDTOS = requestLetterMapper.toResponseDTOList(requestLetters);

        return CompletableFuture.completedFuture(requestLetterResponseDTOS);

    }
}
