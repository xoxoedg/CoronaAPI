package rug.coronaapi.coronatracking.countries.germany.cases;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
