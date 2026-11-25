package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.*;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper_v2;
import gov.nj.treas.NJDPB_API.service.intrface.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AggregateServiceImpl_v2 implements AggregateService_v2 {

    private final MemberApplicationService memberApplicationService;
    private final LetterService letterService;
    private final CommentService commentService;
    private final MSSChecklistService mssChecklistService;

    private final AggregateMapper_v2 aggregateMapper;

    @Override
    public AggregateResponseDTO_v2 findDetails(AggregateRequestDTO aggregateRequestDTO) throws ExecutionException, InterruptedException {


        CompletableFuture<List<MemberApplicationResponseDTO>> memberList = memberApplicationService.getMemberApplicationBySsn(aggregateRequestDTO);
        CompletableFuture<List<LetterResponseDTO>> letterList = letterService.getLetterBySsn(aggregateRequestDTO);
        CompletableFuture<List<CommentResponseDTO>> commentList = commentService.getCommentBySsn(aggregateRequestDTO);

        CompletableFuture<MSSChecklistResponseDTO> mssChecklistResponseDTOCompletableFuture = mssChecklistService.getMSSChecklist(aggregateRequestDTO);

//        CompletableFuture.allOf(memberList,letterList).join(); //blocking call
        CompletableFuture.allOf(memberList,letterList,mssChecklistResponseDTOCompletableFuture).join(); //blocking call

        List<MemberApplicationResponseDTO> members = memberList.get();
        List<LetterResponseDTO> letters = letterList.get();
        List<CommentResponseDTO> comments = commentList.get();
        MSSChecklistResponseDTO mssChecklistResponseDTO = mssChecklistResponseDTOCompletableFuture.get();


//        System.out.println("in aggregate service "+mssChecklistResponseDTO);

        return aggregateMapper.toAggregateResponseDto_v2(
                members,
                letters,
                comments,
                mssChecklistResponseDTO
        );

    }

}