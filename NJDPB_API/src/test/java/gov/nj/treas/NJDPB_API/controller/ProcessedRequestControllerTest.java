package gov.nj.treas.NJDPB_API.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import gov.nj.treas.NJDPB_API.service.impl.ProcessedRequestServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProcessedRequestController.class)
@AutoConfigureMockMvc(addFilters = false) // ✅ disables Spring Security filters
class ProcessedRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProcessedRequestServiceImpl processedRequestService;

    @Autowired
    ObjectMapper objectMapper;

    private AggregateRequestDTO aggregateRequestDTO;
    private ProcessedResponseDTO processedResponseDTO;
    private List<ProcessedResponseDTO> processedResponseDTOList;

    @BeforeEach
    void setUp() {

        aggregateRequestDTO = AggregateRequestDTO.builder().ssn("12345789").build();

        processedResponseDTO = ProcessedResponseDTO.builder()
                .ssn("123456789")
                .request_id(12)
                .build();

//        processedResponseDTOList = List.of(processedResponseDTO);
        processedResponseDTOList = Collections.singletonList(processedResponseDTO);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findBySsn() throws Exception {


        String jsonInput = objectMapper.writeValueAsString(aggregateRequestDTO);

        Mockito.when(processedRequestService.getProcessedRequestBySsn(aggregateRequestDTO))
                .thenReturn(processedResponseDTOList);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/processed_request/find_by_ssn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInput)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ssn").value("123456789"));
    }
}