package gov.nj.treas.NJDPB_API.service.impl;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.calculation.CalculationResponseDTO;
import gov.nj.treas.NJDPB_API.dto.processedrequest.ProcessedResponseDTO;
import gov.nj.treas.NJDPB_API.exception.RecordNotFoundException;
import gov.nj.treas.NJDPB_API.mapper.CalculationMapper;
import gov.nj.treas.NJDPB_API.mapper.ProcessedRequestMapper;
import gov.nj.treas.NJDPB_API.persistence.entity.Calculation;
import gov.nj.treas.NJDPB_API.persistence.entity.ProcessedRequest;
import gov.nj.treas.NJDPB_API.persistence.repository.CalculationRepository;
import gov.nj.treas.NJDPB_API.persistence.repository.ProcessedRequestRepository;
import gov.nj.treas.NJDPB_API.service.intrface.CalculationService;
import gov.nj.treas.NJDPB_API.service.intrface.ProcessedRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculationServiceImpl implements CalculationService {

//    @Autowired
//    CalculationRepository calculationRepository;
//
//    @Autowired
//    CalculationMapper calculationMapper;

    private final CalculationRepository calculationRepository;
    private final CalculationMapper calculationMapper;


    @Override
    @Cacheable(value="calculationResponse",key = "#processedRequestDTO.ssn")
    public List<CalculationResponseDTO> getCalculationBySsn(AggregateRequestDTO processedRequestDTO) {

        String ssn = processedRequestDTO.getSsn();

        List<Calculation> calculations = calculationRepository.findBySsn(ssn);

        if(calculations.isEmpty()) throw new RecordNotFoundException("CALCULATION_SERVICE - Record Not Fount");

        return calculationMapper.toResponseDTOList(calculations);

    }
}
