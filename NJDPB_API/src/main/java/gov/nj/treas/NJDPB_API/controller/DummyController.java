
package gov.nj.treas.NJDPB_API.controller;

import gov.nj.treas.NJDPB_API.dto.AggregateRequestDTO;
import gov.nj.treas.NJDPB_API.dto.member_application.MemberApplicationResponseDTO;
import gov.nj.treas.NJDPB_API.service.intrface.MemberApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Deprecated
@RestController
@RequiredArgsConstructor
public class DummyController {

    private final MemberApplicationService memberApplicationService;

    @PostMapping("/find_member")
    public CompletableFuture<ResponseEntity<?>> findMember(@RequestBody AggregateRequestDTO aggregateRequestDTO){

        CompletableFuture<List<MemberApplicationResponseDTO>> futureData = memberApplicationService.getMemberApplicationBySsn(aggregateRequestDTO);
        return futureData.thenApply(data -> ResponseEntity.ok(data));
    }
}

