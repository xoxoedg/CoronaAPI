package rug.coronaapi.germany.cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GermanyCasesRepositoryTest {

    @Autowired
    private GermanyCasesRepository germanyCasesRepository;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        GermanyCasesEntity entity1 = new GermanyCasesEntity.Builder()
                .bundeslandName("Bayer")
                .deaths(12L)
                .casesUpdated(LocalDate.now())
                .confirmed(10L)
                .recovered(30L)
                .build();

        GermanyCasesEntity entity2 = new GermanyCasesEntity.Builder()
                .bundeslandName("Hessen")
                .deaths(12L)
                .casesUpdated(LocalDate.now())
                .confirmed(1000L)
                .recovered(30L)
                .build();

        entityManager.persist(entity1);
        entityManager.persist(entity2);
    }


    @Test
    void findByCasesUpdatedDate() {
        List<GermanyCasesEntity> actualByCasesUpdatedDate = germanyCasesRepository.findByCasesUpdatedDate(LocalDate.now());
        assertEquals(2, actualByCasesUpdatedDate.size());

    }

    @Test
    void findByBundeslandName() {
        List<GermanyCasesEntity> actualBundesland = germanyCasesRepository.findByBundeslandName("Bayer");
        assertEquals(1, actualBundesland.size());
    }

    @Test
    void findByCasesUpdatedDateAndBundeslandName() {
        Optional<GermanyCasesEntity> actualBundesland = germanyCasesRepository.findByCasesUpdatedDateAndBundeslandName(LocalDate.now(), "Bayer");
        assertNotNull(actualBundesland.orElse(null));

    }

    @Test
    void findTotalCasesByDate() {
        Long expectedConfirmedCases = 1010L;
        Long actualConfirmedCases = germanyCasesRepository.findTotalCasesByDate(LocalDate.now());
        assertEquals(expectedConfirmedCases, actualConfirmedCases);
    }

    @AfterEach
    void tearDown() {
        germanyCasesRepository.deleteAll();
    }
}