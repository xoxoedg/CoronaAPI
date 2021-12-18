package rug.coronaApi.coronatracking.countries.germany.vaccines.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public abstract class BundeslandVaccines {
    private Long administered;
    private Long people_vaccinated;
    private Long people_partially_vaccinated;
    private LocalDateTime updated;


}

