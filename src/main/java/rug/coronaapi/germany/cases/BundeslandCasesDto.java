package rug.coronaapi.germany.cases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BundeslandCasesDto {

    private String bundeslandName;
    private Long recovered;
    private Long confirmed;
    private LocalDate casesUpdatedDate;


    public static class Builder {
        private String name;
        private Long recovered;
        private Long confirmed;
        private LocalDate casesUpdatedDate;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder recovered(Long recovered) {
            this.recovered = recovered;
            return this;
        }

        public Builder confirmed(Long confirmed) {
            this.confirmed = confirmed;
            return this;
        }

        public Builder date(LocalDate dateTime) {
            this.casesUpdatedDate = dateTime;
            return this;
        }

        public BundeslandCasesDto build() {
            return new BundeslandCasesDto(name, recovered, confirmed, casesUpdatedDate);
        }
    }
}
