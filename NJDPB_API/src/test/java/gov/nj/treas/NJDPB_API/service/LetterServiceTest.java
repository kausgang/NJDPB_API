package gov.nj.treas.NJDPB_API.service;


import gov.nj.treas.NJDPB_API.persistence.repository.LetterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("PUR_dev")
public class LetterServiceTest {

    @Autowired
    private LetterRepository letterRepository;

    @Test
    public void findBySSN(){

        assertNotNull(letterRepository.findBySsn("158-44-2651"));
    }
}
