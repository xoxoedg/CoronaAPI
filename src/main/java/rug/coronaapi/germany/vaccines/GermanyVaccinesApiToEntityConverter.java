package rug.coronaapi.germany.vaccines;

import rug.coronaapi.germany.vaccines.mapping.Bundeslaender;
import rug.coronaapi.germany.vaccines.mapping.BundeslandVaccines;

import java.util.List;

public class GermanyVaccinesApiToEntityConverter {

    public static GermanyVaccinesEntity convertToEntity(BundeslandVaccines bundesland) {
        return new GermanyVaccinesEntity.Builder()
                .vaccine(bundesland.getAdministered())
                .name(bundesland.getName())
                .updated(bundesland.getUpdated().toLocalDate())
                .build();

    }

    public static List<GermanyVaccinesEntity> convertAllToEntity(Bundeslaender germanyVaccines) {
        return List.of(convertToEntity(germanyVaccines.getBayern()),
                convertToEntity(germanyVaccines.getBadenWurttemberg()), convertToEntity(germanyVaccines.getBerlin()),
                convertToEntity(germanyVaccines.getBrandenburg()), convertToEntity(germanyVaccines.getBremen()),
                convertToEntity(germanyVaccines.getHamburg()), convertToEntity(germanyVaccines.getHessen()),
                convertToEntity(germanyVaccines.getMecklenburgVorpommern()), convertToEntity(germanyVaccines.getNiedersachsen()),
                convertToEntity(germanyVaccines.getNordrheinWestfalen()), convertToEntity(germanyVaccines.getSaarland()),
                convertToEntity(germanyVaccines.getSachsen()), convertToEntity(germanyVaccines.getSachsenAnhalt()),
                convertToEntity(germanyVaccines.getSchleswigHolstein()), convertToEntity(germanyVaccines.getThuringen()));
    }
}
