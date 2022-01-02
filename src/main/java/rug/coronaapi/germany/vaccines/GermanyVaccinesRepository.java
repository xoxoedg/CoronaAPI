package rug.coronaapi.germany.vaccines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GermanyVaccinesRepository extends JpaRepository<GermanyVaccinesEntity, Long> {

    List<GermanyVaccinesEntity> findByVaccinesUpdatedDate(LocalDate date);

    List<GermanyVaccinesEntity> findByBundeslandName(String name);

    @Query("select sum(g.fullyVaccinated) from GermanyVaccinesEntity as g where g.vaccinesUpdatedDate = ?1")
    Long findAllVaccinated(LocalDate date);

}
