package rug.coronaapi.germany.vaccines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BundeslandVaccineDto {

    private String bundeslandName;
    private Long vaccinated;
    private LocalDate casesUpdatedDate;

     static class Builder{
        private String bundeslandName;
        private Long vaccinated;
        private LocalDate casesUpdatedDate;

        public Builder name(String bundeslandName) {
            this.bundeslandName = bundeslandName;
            return this;
        }
        public Builder vaccinated(Long vaccinated) {
            this.vaccinated = vaccinated;
            return this;
        }

        public Builder date(LocalDate date) {
            this.casesUpdatedDate = date;
            return this;
        }

        public BundeslandVaccineDto build() {
            return new BundeslandVaccineDto(bundeslandName, vaccinated, casesUpdatedDate);
        }
    }

}
