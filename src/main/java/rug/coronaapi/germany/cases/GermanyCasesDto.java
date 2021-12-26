package rug.coronaapi.germany.cases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class GermanyCasesDto {
    private final String country = "Germany";
    private Long totalConfirmed;
    private LocalDate casesUpdatedDate;

    public static class Builder {
        private Long totalConfirmed;
        private LocalDate casesUpdatedDate;

        public Builder confirmed(Long totalConfirmed) {
            this.totalConfirmed = totalConfirmed;
            return this;
        }

        public Builder updated(LocalDate updated) {
            this.casesUpdatedDate = updated;
            return this;
        }

        public GermanyCasesDto build() {
            return new GermanyCasesDto(totalConfirmed, casesUpdatedDate);
        }


    }
}
