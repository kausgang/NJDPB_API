package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.annotation.DebugLogging;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedRequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.requestComment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
import gov.nj.treas.NJDPB_API.service.intrface.*;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
//@AllArgsConstructor
public class AggregateServiceImpl implements AggregateService {



    private final MemberService memberService;
    private final ProcessedRequestService processedRequestService;
//    private final K_ProcessedRequestServiceImpl processedRequestService;
    private final CalculationService calculationService;
    private final RequestCommentService requestCommentService;
    private final LetterService letterService;
    private final AggregateMapper aggregateMapper;

    private List<CalculationResponseDTO> calculation;
    private List<MemberResponseDTO> members;
    private List<ProcessedResponseDTO> processed_requests;
    private List<RequestCommentResponseDTO> requestComments;
    private List<LetterResponseDTO> letters;

//    private List<ProcessedResponseDTO> processed_requests;


    @Override
    @Transactional
    @Cacheable(value="aggregateResponse",key = "#aggregateRequestDTO.ssn")
    @DebugLogging
    public AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO) throws ExecutionException, InterruptedException {



//        List<MemberResponseDTO> members = memberService.getMembersBySsn(aggregateRequestDTO);

//        List<ProcessedResponseDTO> processed_requests = processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO);
//        log.debug("Retrieved ProcessedRequests = {}",processed_requests);

//        List<CalculationResponseDTO> calculation = calculationService.getCalculationBySsn(aggregateRequestDTO);
//        log.debug("Retrieved Calculation = {}",calculation);




//        List<RequestCommentResponseDTO> requestComments = requestCommentService.getRequestCommentBySsn(aggregateRequestDTO);
//        log.debug("Retrieved Request Comment = {}",requestComments);

//        List<LetterResponseDTO> letters = letterService.getLetterBySsn(aggregateRequestDTO);
//        log.debug("Retrieved letters = {}",requestComments);


        CompletableFuture<List<MemberResponseDTO>> memberList = memberService.getMembersBySsn(aggregateRequestDTO);
        CompletableFuture<List<ProcessedResponseDTO>> processedRequestList = processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO);

        CompletableFuture.allOf(memberList,processedRequestList).join();

        members = memberList.get();
        processed_requests = processedRequestList.get();



        return aggregateMapper.toAggregateResponseDto(
                members,
                processed_requests,
                calculation,
                requestComments,
                letters
        );

    }



}
