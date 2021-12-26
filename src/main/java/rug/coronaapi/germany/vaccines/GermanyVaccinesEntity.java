package rug.coronaapi.germany.vaccines;

import lombok.Getter;
import rug.coronaapi.Audit;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Table(name = "Germany_Vaccines", uniqueConstraints = {@UniqueConstraint(columnNames = {"Bundesland", "LastUpdated"})})
@Entity
public class GermanyVaccinesEntity extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Bundesland", nullable = false)
    private String bundeslandName;
    @Column(name = "Vaccinated", nullable = false)
    private Long fullyVaccinated;
    @Column(name = "LastUpdated", nullable = false)
    private LocalDate vaccinesUpdatedDate;

    public GermanyVaccinesEntity(String bundeslandName, Long fullyVaccinated, LocalDate vaccinesUpdatedDate) {
        this.bundeslandName = bundeslandName;
        this.fullyVaccinated = fullyVaccinated;
        this.vaccinesUpdatedDate = vaccinesUpdatedDate;
    }

    public GermanyVaccinesEntity() {
    }

    public static class Builder {
        private String bundeslandName;
        private Long fullyVaccinated;
        private LocalDate vaccinesUpdatedDate;


        public Builder name(String bundeslandName) {
            this.bundeslandName = bundeslandName;
            return this;
        }

        public Builder vaccine(Long vaccinated) {
            this.fullyVaccinated = vaccinated;
            return this;
        }

        public Builder updated(LocalDate vaccinesUpdatedDate) {
            this.vaccinesUpdatedDate = vaccinesUpdatedDate;
            return this;
        }

        public GermanyVaccinesEntity build() {
            return new GermanyVaccinesEntity(bundeslandName, fullyVaccinated, vaccinesUpdatedDate);
        }
    }
}

