package rug.coronaapi.coronatracking.countries.germany.cases;

import org.springframework.stereotype.Component;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.BundeslandCases;

@Component
public class GermanyApiToEntityConverter {

    public   GermanyCasesEntity convertToEntity(BundeslandCases bundesland) {
        return new GermanyCasesEntity.Builder()
                .bundeslandName(bundesland.getName())
                .confirmed(bundesland.getConfirmed())
                .deaths(bundesland.getDeaths())
                .recovered(bundesland.getRecovered())
                .casesUpdated(bundesland.getUpdated())
                .build();


    }
}
