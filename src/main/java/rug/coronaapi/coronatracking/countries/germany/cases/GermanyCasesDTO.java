package rug.coronaapi.coronatracking.countries.germany.cases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GermanyCasesDTO {

    private String bundeslandName;
    private Long recovered;
    private Long confirmed;
    private LocalDateTime casesUpdatedDate;


    public static class Builder {
        private String bundeslandName;
        private Long recovered;
        private Long confirmed;
        private LocalDateTime casesUpdatedDate;


        public Builder name(String name) {
            this.bundeslandName = name;
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

        public Builder date(LocalDateTime dateTime) {
            this.casesUpdatedDate = dateTime;
            return this;
        }

        public GermanyCasesDTO build() {
            return new GermanyCasesDTO(bundeslandName, recovered, confirmed, casesUpdatedDate);
        }
    }
}
