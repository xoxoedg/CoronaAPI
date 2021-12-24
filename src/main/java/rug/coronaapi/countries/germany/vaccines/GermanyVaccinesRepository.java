package rug.coronaapi.countries.germany.vaccines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GermanyVaccinesRepository extends JpaRepository<GermanyVaccinesEntity, Long> {
}
