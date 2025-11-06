package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import gov.nj.treas.NJDPB_API.dto.request_comment.RequestCommentResponseDTO;
import gov.nj.treas.NJDPB_API.dto.request_letter.RequestLetterResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
import gov.nj.treas.NJDPB_API.service.intrface.*;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AggregateServiceImpl implements AggregateService {

    private final MemberService memberService;
    private final ProcessedRequestService processedRequestService;
    private final RequestCommentService requestCommentService;
    private final RequestLetterService requestLetterService;


    private final AggregateMapper aggregateMapper;

    @Override
//    @Cacheable(value="aggregateResponse",key = "#aggregateRequestDTO.ssn")
//    @RateLimiter(name = "api-rate-limit")
    public AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO) throws ExecutionException, InterruptedException {


        CompletableFuture<List<MemberResponseDTO>> memberList = memberService.getMembersBySsn(aggregateRequestDTO);
        CompletableFuture<List<ProcessedRequestResponseDTO>> processedRequestList = processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO);
        CompletableFuture<List<RequestCommentResponseDTO>> requestCommentList = requestCommentService.getRequestCommentBySsn(aggregateRequestDTO);
        CompletableFuture<List<RequestLetterResponseDTO>> requestLetterList = requestLetterService.getRequestLetterBySsn(aggregateRequestDTO);

        CompletableFuture.allOf(
                memberList,
                processedRequestList,
                requestCommentList,
                requestLetterList

        ).join(); //blocking call

        List<MemberResponseDTO> members = memberList.get();
        List<ProcessedRequestResponseDTO> processedRequests = processedRequestList.get();
        List<RequestCommentResponseDTO> requestComments = requestCommentList.get();
        List<RequestLetterResponseDTO> requestLetters = requestLetterList.get();

        return aggregateMapper.toAggregateResponseDto(
                members,
                processedRequests,
                requestComments,
                requestLetters
        );

    }

}