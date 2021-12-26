package rug.coronaapi.countries.germany.vaccines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rug.coronaapi.countries.germany.vaccines.mapping.Bayern;
import rug.coronaapi.countries.germany.vaccines.mapping.BundeslandVaccines;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GermanyVaccinesApiToEntityConverterTest {
    BundeslandVaccines  bundeslandVaccines;
    @BeforeEach
    void setUp() {
        bundeslandVaccines = new Bayern();
        bundeslandVaccines.setAdministered(100L);
        bundeslandVaccines.setName("Bayern");
        bundeslandVaccines.setUpdated(LocalDateTime.of(2021,12, 26,3,5,10));
    }

    @Test
    void convertToEntity() {
        GermanyVaccinesEntity expectedValue = new GermanyVaccinesEntity.Builder()
                .vaccine(100L)
                .name("Bayern")
                .updated(LocalDate.of(2021,12,26))
                .build();
        GermanyVaccinesEntity actualValue = GermanyVaccinesApiToEntityConverter
                .convertToEntity(bundeslandVaccines);
        assertEquals(expectedValue.getBundeslandName(), actualValue.getBundeslandName());
        assertEquals(expectedValue.getVaccinesUpdatedDate(), actualValue.getVaccinesUpdatedDate());
        assertEquals(expectedValue.getFullyVaccinated(), actualValue.getFullyVaccinated());



    }

    @Test
    void convertAllToEntity() {
    }
}