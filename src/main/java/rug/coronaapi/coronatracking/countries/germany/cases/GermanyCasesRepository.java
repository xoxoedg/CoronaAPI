package rug.coronaapi.coronatracking.countries.germany.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanyCasesRepository extends JpaRepository<GermanyCasesEntity, Long> {
}
