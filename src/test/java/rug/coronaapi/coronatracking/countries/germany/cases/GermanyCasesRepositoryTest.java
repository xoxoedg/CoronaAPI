package rug.coronaapi.coronatracking.countries.germany.cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class GermanyCasesRepositoryTest {

    @Autowired
    private GermanyCasesRepository germanyCasesRepository;


    @BeforeEach
    void setUp() {
        GermanyCasesEntity entity = new GermanyCasesEntity.Builder()
                .bundeslandName("Bayer")
                .deaths(12L)
                .casesUpdated(LocalDate.now())
                .confirmed(10L)
                .recovered(30L)
                .build();
        germanyCasesRepository.save(entity);
    }


    @AfterEach
    void tearDown() {
        germanyCasesRepository.deleteAll();
    }

    @Test
    void findByCasesUpdatedDate() {
        List<GermanyCasesEntity> actualByCasesUpdatedDate = germanyCasesRepository.findByCasesUpdatedDate(LocalDate.now());
        assertEquals(1, actualByCasesUpdatedDate.size());

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
}