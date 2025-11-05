package gov.nj.treas.NJDPB_API.persistence.repository;

import gov.nj.treas.NJDPB_API.persistence.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Member member;

    @BeforeEach
    void setUp() {

        member = Member
                .builder()
                .ssn("123456789")
                .member_num("987654321")
                .name("kaustav")
                .build();

        testEntityManager.persist(member);
        testEntityManager.flush();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findBySsnTest_MemberFound() {

        List<Member> members = memberRepository.findBySsn("123456789");

        Assertions.assertThat(members).isNotEmpty();
    }

    @Test
    void findBySsnTest_MemberNotFound(){

        List<Member> members = memberRepository.findBySsn("111111111");

        Assertions.assertThat(members).isEmpty();
    }
}