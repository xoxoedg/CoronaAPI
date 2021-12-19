package rug.coronaapi.coronatracking.countries.germany.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GermanyCasesRepository extends JpaRepository<GermanyCasesEntity, Long> {

    List<GermanyCasesEntity> findByCasesUpdatedDate(LocalDate casesUpdatedDate);

    List<GermanyCasesEntity> findByBundeslandName(String bundeslandName);

    List<GermanyCasesEntity> findByCasesUpdatedDateAndBundeslandName(LocalDate casesUpdatedDate,
                                                                     String bundeslandName);
}
