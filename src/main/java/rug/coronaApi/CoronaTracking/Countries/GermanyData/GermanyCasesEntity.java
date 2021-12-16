package rug.coronaApi.CoronaTracking.Countries.GermanyData;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class GermanyCasesEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Bundesland")
    private String bundeslandName;
    private BigInteger recovered;
    private BigInteger deaths;
    private BigInteger confirmed;
    private LocalDateTime updated;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;


    public GermanyCasesEntity(String bundeslandName, BigInteger recovered, BigInteger deaths, BigInteger confirmed, LocalDateTime updated) {
        this.bundeslandName = bundeslandName;
        this.recovered = recovered;
        this.deaths = deaths;
        this.confirmed = confirmed;
        this.updated = updated;
    }

    static class Builder {
        private String bundeslandName;
        private BigInteger recovered;
        private BigInteger deaths;
        private BigInteger confirmed;
        private LocalDateTime casesUpdated;

        public Builder bundeslandName(String name) {
            this.bundeslandName = name;
            return this;
        }

        public Builder recovered(BigInteger recovered) {
            this.recovered = recovered;
            return this;
        }

        public Builder deaths(BigInteger deaths) {
            this.deaths = deaths;
            return this;
        }

        public Builder confirmed(BigInteger confirmed) {
            this.confirmed = confirmed;
            return this;
        }

        public Builder casesUpdated(LocalDateTime time) {
            this.casesUpdated = time;
            return this;
        }

        public GermanyCasesEntity build() {
            return new GermanyCasesEntity(bundeslandName, recovered, deaths, confirmed, casesUpdated);
        }

    }

}
