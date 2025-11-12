package gov.nj.treas.NJDPB_API.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.nj.treas.NJDPB_API.config.SecurityConfigTest;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.persistence.entity.RequestComment;
import gov.nj.treas.NJDPB_API.persistence.entity.processed_request.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.entity.request_letter.RequestLetter;
import gov.nj.treas.NJDPB_API.persistence.repository.MemberRepository;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.persistence.repository.RequestCommentRepository;
import gov.nj.treas.NJDPB_API.persistence.repository.RequestLetterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Import(SecurityConfigTest.class) // ✅ your custom security confi
public class AggregateIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    MemberRepository memberRepository;

    @MockitoBean
    ProcessedRequestRepository processedRequestRepository;
    @MockitoBean
    RequestCommentRepository requestCommentRepository;
    @MockitoBean
    RequestLetterRepository requestLetterRepository;

    @Autowired
    ObjectMapper objectMapper;


    private AggregateRequestDTO aggregateRequestDTO;


    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;


    @BeforeEach
    void setUp(){

        aggregateRequestDTO = AggregateRequestDTO.builder().ssn("123456789").build();

        Member member = Member.builder().ssn("123456789").build();
        List<Member> memberList = Collections.singletonList(member);

        ProcessedRequest processedRequest = ProcessedRequest.builder().build();
        List<ProcessedRequest> processedRequestList = Collections.singletonList(processedRequest);

        RequestComment requestComment = RequestComment.builder().build();
        List<RequestComment> requestCommentList = Collections.singletonList(requestComment);

        RequestLetter requestLetter = RequestLetter.builder().build();
        List<RequestLetter> requestLetterList = Collections.singletonList(requestLetter);


        Mockito.when(memberRepository.findBySsn(Mockito.anyString()))
                .thenReturn(memberList);

        Mockito.when(processedRequestRepository.findByProcessedRequestIdSsn(Mockito.anyString()))
                .thenReturn(processedRequestList);

        Mockito.when(requestCommentRepository.findBySsn(Mockito.anyString()))
                .thenReturn(requestCommentList);

        Mockito.when(requestLetterRepository.findByRequestLetterIdSsn(Mockito.anyString()))
                .thenReturn(requestLetterList);

    }



    @Test
    void findBySsnTest_MemberFound() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/details")
                        .with(httpBasic(username,password))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aggregateRequestDTO))

        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.members[0].ssn").value("123456789"));
    }

}
