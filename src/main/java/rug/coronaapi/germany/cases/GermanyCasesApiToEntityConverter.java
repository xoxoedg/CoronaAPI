package rug.coronaapi.germany.cases;

import rug.coronaapi.germany.cases.mapping.Bundeslaender;
import rug.coronaapi.germany.cases.mapping.BundeslandCases;

import java.util.List;


public class GermanyCasesApiToEntityConverter {

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
