package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.mapper.MemberMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    MemberMapper memberMapper;

    @InjectMocks
    MemberServiceImpl memberServiceImpl;

    private AggregateRequestDTO aggregateRequestDTO;
    private Member member;
    private MemberResponseDTO memberResponseDTO;


    @BeforeEach
    void setUp() {

        aggregateRequestDTO = AggregateRequestDTO.builder()
                .ssn("123456789")
                .build();

        member = Member.builder()
                .ssn("123456789")
                .name("Kaustav")
                .build();

        memberResponseDTO = MemberResponseDTO.builder()
                .ssn("123456789")
                .name("Kaustav")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMembersBySsn() throws ExecutionException, InterruptedException, TimeoutException {

        List<Member> memberList = List.of(member);
        List<MemberResponseDTO> expectedResponseDTOList = List.of(memberResponseDTO);
        String ssn = aggregateRequestDTO.getSsn();

        // 1. Setup mock for Repository (Stubbing)
        Mockito.when(memberRepository.findBySsn(ssn)).thenReturn(memberList);

        // 2. Setup Mock for Mapper (Stubbing)
        Mockito.when(memberMapper.toResponseDTOList(memberList)).thenReturn(expectedResponseDTOList);

        // 3. Call the method under test
        CompletableFuture<List<MemberResponseDTO>> futureResponse =
                memberServiceImpl.getMembersBySsn(aggregateRequestDTO);

        // 4. Extract the result from the CompletableFuture and Assert
        List<MemberResponseDTO> actualResponseDTOList = futureResponse.get(2, TimeUnit.SECONDS);

        assertEquals(expectedResponseDTOList.size(), actualResponseDTOList.size());
        assertEquals(expectedResponseDTOList.getFirst().getSsn(), actualResponseDTOList.getFirst().getSsn());
        assertEquals(expectedResponseDTOList.getFirst().getName(), actualResponseDTOList.getFirst().getName());


    }
}