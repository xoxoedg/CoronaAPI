package rug.coronaapi.germany.vaccines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class GermanyVaccinesDto {
    private final String country = "Germany";
    private Long totalVaccinated;
    private LocalDate vaccinesUpdatedDate;

    public static class Builder {
        private Long totalVaccinated;
        private LocalDate vaccinesUpdatedDate;

        public Builder totalVaccinated(Long vaccinated) {
            this.totalVaccinated = vaccinated;
            return this;
        }

        public Builder updated(LocalDate date) {
            this.vaccinesUpdatedDate = date;
            return this;
        }

        public GermanyVaccinesDto build() {
            return new GermanyVaccinesDto(totalVaccinated, vaccinesUpdatedDate);
        }
    }
}
