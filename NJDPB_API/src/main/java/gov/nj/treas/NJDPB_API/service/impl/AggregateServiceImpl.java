package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.letter.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.K_ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.dto.requestromment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
import gov.nj.treas.NJDPB_API.service.intrface.*;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
//@AllArgsConstructor

public class AggregateServiceImpl implements AggregateService {

//    @Autowired
//    private MemberServiceImpl memberService;
//
//    @Autowired
//    private ProcessedRequestServiceImpl processedRequestService;
//
//    @Autowired
//    private CalculationServiceImpl calculationService;
//
//    @Autowired
//    private RequestCommentImpl requestCommentService;
//
//    @Autowired
//    private LetterServiceImpl letterService;
//
//    @Autowired
//    private AggregateMapper aggregateMapper;


    private final MemberService memberService;
//    private final ProcessedRequestService processedRequestService;
    private final K_ProcessedRequestServiceImpl processedRequestService;
    private final CalculationService calculationService;
    private final RequestCommentService requestCommentService;
    private final LetterService letterService;
    private final AggregateMapper aggregateMapper;

    private List<CalculationResponseDTO> calculation;

    private List<ProcessedResponseDTO> processed_requests;


    @Override
    @Transactional
    @Cacheable(value="aggregateResponse",key = "#aggregateRequestDTO.ssn")
    public AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO) {


        log.info("received Aggregate Request Object {}",aggregateRequestDTO);

        log.debug("Calling Member Service");
        List<MemberResponseDTO> members = memberService.getMembersBySsn(aggregateRequestDTO);
        log.debug("Retrieved Members = {}",members);

//        log.debug("Calling ProcessedRequest Service");
//        List<ProcessedResponseDTO> processed_requests = processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO);
//        log.debug("Retrieved ProcessedRequests = {}",processed_requests);

//        log.debug("Calling Calculation Service");
//        List<CalculationResponseDTO> calculation = calculationService.getCalculationBySsn(aggregateRequestDTO);
//        log.debug("Retrieved Calculation = {}",calculation);

        log.debug("Calling Request Comment Service");
        List<RequestCommentResponseDTO> requestComments = requestCommentService.getRequestCommentBySsn(aggregateRequestDTO);
        log.debug("Retrieved Request Comment = {}",requestComments);

        log.debug("Calling Letter Service");
        List<LetterResponseDTO> letters = letterService.getLetterBySsn(aggregateRequestDTO);
        log.debug("Retrieved letters = {}",requestComments);

//        return aggregateMapper.toAggregateResponseDto(members,processed_requests);
        return aggregateMapper.toAggregateResponseDto(
                members,
                processed_requests,
                calculation,
                requestComments,
                letters
        );

    }
}
