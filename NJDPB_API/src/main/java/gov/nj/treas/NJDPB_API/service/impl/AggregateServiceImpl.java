package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.AggregateMapper;
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
public class AggregateServiceImpl implements AggregateService {

    private final MemberApplicationService memberApplicationService;
    private final LetterService letterService;

    private final AggregateMapper aggregateMapper;

    @Override
    public AggregateResponseDTO findDetails(AggregateRequestDTO aggregateRequestDTO) throws ExecutionException, InterruptedException {


        CompletableFuture<List<MemberApplicationResponseDTO>> memberList = memberApplicationService.getMemberApplicationBySsn(aggregateRequestDTO);
        CompletableFuture<List<LetterResponseDTO>> letterList = letterService.getLetterBySsn(aggregateRequestDTO);

        CompletableFuture.allOf(memberList,letterList).join(); //blocking call

        List<MemberApplicationResponseDTO> members = memberList.get();
        List<LetterResponseDTO> letters = letterList.get();


        return aggregateMapper.toAggregateResponseDto(
                members,
                letters
        );

    }

}