package rug.coronaapi.germany.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface GermanyCasesRepository extends JpaRepository<GermanyCasesEntity, Long> {
    
    List<GermanyCasesEntity> findByCasesUpdatedDate(LocalDate casesUpdatedDate);

    List<GermanyCasesEntity> findByBundeslandName(String bundeslandName);

    Optional<GermanyCasesEntity> findByCasesUpdatedDateAndBundeslandName(LocalDate casesUpdatedDate,
                                                                        String bundeslandName);
    @Query("select sum(g.confirmed) from GermanyCasesEntity as g where g.casesUpdatedDate = ?1")
    Long findTotalCasesByDate(LocalDate date);
}
