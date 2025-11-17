package gov.nj.treas.NJDPB_API.service.intrface;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MemberApplicationService {

    CompletableFuture<List<MemberApplicationResponseDTO>> getMemberApplicationBySsn(AggregateRequestDTO aggregateRequestDTO);
}
