package rug.coronaapi.coronatracking.countries.germany.cases;

import rug.coronaapi.coronatracking.countries.germany.cases.mapping.Bundeslaender;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.BundeslandCases;

import java.util.List;


public class GermanyApiToEntityConverter {

    public static GermanyCasesEntity convertToEntity(BundeslandCases bundesland) {
        return new GermanyCasesEntity.Builder()
                .bundeslandName(bundesland.getName())
                .confirmed(bundesland.getConfirmed())
                .deaths(bundesland.getDeaths())
                .recovered(bundesland.getRecovered())
                .casesUpdated(bundesland.getUpdated().toLocalDate())
                .build();
    }

    public static List<GermanyCasesEntity> covertAllToEntity(Bundeslaender germanyCases) {
        return List.of(convertToEntity(germanyCases.getBayern()),
                convertToEntity(germanyCases.getBadenWurttemberg()), convertToEntity(germanyCases.getBerlin()),
                convertToEntity(germanyCases.getBrandenburg()), convertToEntity(germanyCases.getBremen()),
                convertToEntity(germanyCases.getHamburg()), convertToEntity(germanyCases.getHessen()),
                convertToEntity(germanyCases.getMecklenburgVorpommern()), convertToEntity(germanyCases.getNiedersachsen()),
                convertToEntity(germanyCases.getNordrheinWestfalen()), convertToEntity(germanyCases.getSaarland()),
                convertToEntity(germanyCases.getSachsen()), convertToEntity(germanyCases.getSachsenAnhalt()),
                convertToEntity(germanyCases.getSchleswigHolstein()), convertToEntity(germanyCases.getThuringen()));
    }
}
