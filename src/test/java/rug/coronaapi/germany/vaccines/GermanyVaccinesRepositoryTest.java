package rug.coronaapi.germany.vaccines;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.Month;
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
        GermanyVaccinesEntity entity1 = new GermanyVaccinesEntity.Builder()
                .vaccine(1500L)
                .name("Sachsen")
                .updated(LocalDate.of(2022, Month.JANUARY, 1))
                .build();

        GermanyVaccinesEntity entity2 = new GermanyVaccinesEntity.Builder()
                .vaccine(3000L)
                .name("Sachsen")
                .updated(LocalDate.of(2022, Month.JANUARY, 2))
                .build();

        entityManager.persist(entity1);
        entityManager.persist(entity2);

    }

    @Test
    void findByDate() {
        List<GermanyVaccinesEntity> actualEntity = repository.findByVaccinesUpdatedDate(LocalDate.of(2022, Month.JANUARY, 1));
        assertNotNull(actualEntity);
        assertEquals(1, actualEntity.size());
        assertEquals(actualEntity.get(0).getBundeslandName(), "Sachsen");
    }

    @Test
    void findByBundeslandName() {
        List<GermanyVaccinesEntity> actualEntity = repository.findByBundeslandName("Sachsen");
        assertNotNull(actualEntity);
        assertEquals(actualEntity.size(), 2);
        assertEquals(1500L, actualEntity.get(0).getFullyVaccinated());
        assertEquals(3000L, actualEntity.get(1).getFullyVaccinated());
    }

    @Test
    void findAllVaccinated() {
        GermanyVaccinesEntity entity3 = new GermanyVaccinesEntity.Builder()
                .updated(LocalDate.of(2022, Month.JANUARY, 1))
                .name("Thüringen")
                .vaccine(3200L)
                .build();
        entityManager.persist(entity3);

        Long expectedSumOfVaccinated = repository.findAllVaccinated(LocalDate.of(2022, Month.JANUARY, 1));
        assertEquals(4700L, expectedSumOfVaccinated);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }
}