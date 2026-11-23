package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.MSSChecklist;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MSSChecklistRepository extends JpaRepository<MSSChecklist,Integer> {



        @Query(
                """
                        select mc.desc_type_ret
                        from MemberApplication ma
                        join MSSChecklist mc
                            on ma.idn_member_num = mc.idn_member_num
                        where ma.ssnMember = :ssn
                        """
        )
        String findRetirementTypeBySsn(@Param("ssn") String ssn);



}
