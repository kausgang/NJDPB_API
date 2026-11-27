package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.MSSChecklist;
import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MSSChecklistRepositoryTest {

    @Autowired
    MemberApplicationRepository memberApplicationRepository;
    @Autowired
    MSSChecklistRepository mssChecklistRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        MemberApplication memberApplication = MemberApplication.builder()
                .idn_member_num(1234567)
                .ssnMember("123456789").build();

        testEntityManager.persistAndFlush(memberApplication);


        MSSChecklist mssChecklist = MSSChecklist.builder()
                .idn_member_num(1234567)
                .desc_type_ret("P")
                .build();

//        MSSChecklist mssChecklist1 = MSSChecklist.builder()
//                .idn_member_num(12345678)
//                .desc_type_ret("S")
//                .build();

        testEntityManager.persistAndFlush(mssChecklist);
//        testEntityManager.persistAndFlush(mssChecklist1);

    }


    @Test
    void findBySsnNumber() {

//        List<MemberApplication> ma = memberApplicationRepository.findBySsnMember("123456789");

        String type = mssChecklistRepository
                .findRetirementTypeBySsn("123456789");

//        assertEquals(1,ma.size());
//        assertEquals("123456789",ma.getFirst().getSsnMember());

//        assertEquals(1,type.);

//        assertTrue(type);
        assertEquals("P",type);
    }
}
