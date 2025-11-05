package gov.nj.treas.NJDPB_API.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.nj.treas.NJDPB_API.config.SecurityConfig;
import gov.nj.treas.NJDPB_API.config.SecurityConfigTest;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.AggregateResponseDTO;
import gov.nj.treas.NJDPB_API.dto.member.MemberResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processed_request.ProcessedRequestResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import gov.nj.treas.NJDPB_API.service.intrface.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@Slf4j
@WebMvcTest(AggregateController.class)
//@AutoConfigureMockMvc(addFilters = false) // ✅ disables Spring Security filters
@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
@Import(SecurityConfigTest.class) // ✅ your custom security confi
class AggregateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    AggregateService aggregateService;

    @Autowired
    ObjectMapper objectMapper;

    private AggregateRequestDTO aggregateRequestDTO;
    private AggregateResponseDTO aggregateResponseDTO;
    private MemberResponseDTO memberResponseDTO;
    private List<MemberResponseDTO> memberResponseDTOList;
    private ProcessedRequestResponseDTO processedRequestResponseDTO;
    private List<ProcessedRequestResponseDTO> processedRequestResponseDTOList;



    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;



    @BeforeEach
    void setUp() {


        aggregateRequestDTO = AggregateRequestDTO.builder().ssn("123456789").build();

        memberResponseDTO = MemberResponseDTO.builder().ssn("123456789").build();
        memberResponseDTOList = Collections.singletonList(memberResponseDTO);

        processedRequestResponseDTO = ProcessedRequestResponseDTO.builder().ssn("123456789").build();
        processedRequestResponseDTOList = Collections.singletonList(processedRequestResponseDTO);

        aggregateResponseDTO = AggregateResponseDTO.builder()
                .members(memberResponseDTOList)
                .processed_request(processedRequestResponseDTOList)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDetails() throws Exception {

        Mockito.when(aggregateService.findDetails(aggregateRequestDTO)).thenReturn(aggregateResponseDTO);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/details")
                        .with(httpBasic(username,password))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aggregateRequestDTO))

        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}