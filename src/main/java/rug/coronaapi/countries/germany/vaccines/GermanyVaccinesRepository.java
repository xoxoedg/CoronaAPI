package rug.coronaapi.countries.germany.vaccines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GermanyVaccinesRepository extends JpaRepository<GermanyVaccinesEntity, Long> {

    List<GermanyVaccinesEntity> findByVaccinesUpdatedDate(LocalDate date);

    List<GermanyVaccinesEntity> findByBundeslandName(String name);

}
