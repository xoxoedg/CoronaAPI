package rug.coronaapi.germany.vaccines;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GermanyVaccinesRepositoryTest {

    @Autowired
    private GermanyVaccinesRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        GermanyVaccinesEntity entity = new GermanyVaccinesEntity.Builder()
                .vaccine(1500L)
                .name("Sachsen")
                .updated(LocalDate.now())
                .build();
        entityManager.persist(entity);

    }

    @Test
    void findByDate() {
        List<GermanyVaccinesEntity> actualEntity = repository.findByVaccinesUpdatedDate(LocalDate.now());
        assertNotNull(actualEntity);
        assertEquals(actualEntity.size(), 1);
        assertEquals(actualEntity.get(0).getBundeslandName(), "Sachsen");
    }

    @Test
    void findByBundeslandName() {
        GermanyVaccinesEntity entity2 = new GermanyVaccinesEntity.Builder()
                .vaccine(3000L)
                .name("Sachsen")
                .updated(LocalDate.of(2021, 12, 24))
                .build();
        entityManager.persist(entity2);
        List<GermanyVaccinesEntity> actualEntity = repository.findByBundeslandName("Sachsen");
        assertNotNull(actualEntity);
        assertEquals(actualEntity.size(), 2);
        assertEquals(actualEntity.get(0).getFullyVaccinated(), 3000L);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }
}