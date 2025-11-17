package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.MemberApplication;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberApplicationRepositoryTest {

    @Autowired
    MemberApplicationRepository memberApplicationRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        MemberApplication memberApplication = MemberApplication.builder()
                .idn_member_num(1)
                .ssnNumber("123456789").build();

        testEntityManager.persistAndFlush(memberApplication);

    }

    @Test
    void findBySsnNumber() {

        List<MemberApplication> ma = memberApplicationRepository.findBySsnNumber("123456789");

        assertEquals(1,ma.size());
        assertEquals("123456789",ma.getFirst().getSsnNumber());
    }
}