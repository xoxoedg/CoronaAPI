package rug.coronaapi.coronatracking.countries.germany.cases;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Table(name = "Germany_Cases")
@Entity
public class GermanyCasesEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Bundesland")
    private String bundeslandName;
    private Long recovered;
    private Long deaths;
    private Long confirmed;
    private LocalDate casesUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public GermanyCasesEntity() {
    }

    public GermanyCasesEntity(String bundeslandName, Long recovered, Long deaths, Long confirmed, LocalDate casesUpdatedDate) {
        this.bundeslandName = bundeslandName;
        this.recovered = recovered;
        this.deaths = deaths;
        this.confirmed = confirmed;
        this.casesUpdatedDate = casesUpdatedDate;
    }

    static class Builder {
        private String bundeslandName;
        private Long recovered;
        private Long deaths;
        private Long confirmed;
        private LocalDate casesUpdatedDate;

        public Builder bundeslandName(String name) {
            this.bundeslandName = name;
            return this;
        }

        public Builder recovered(Long recovered) {
            this.recovered = recovered;
            return this;
        }

        public Builder deaths(Long deaths) {
            this.deaths = deaths;
            return this;
        }

        public Builder confirmed(Long confirmed) {
            this.confirmed = confirmed;
            return this;
        }

        public Builder casesUpdated(LocalDate time) {
            this.casesUpdatedDate = time;
            return this;
        }


        public GermanyCasesEntity build() {
            return new GermanyCasesEntity(bundeslandName, recovered, deaths, confirmed, casesUpdatedDate);
        }

    }

}
