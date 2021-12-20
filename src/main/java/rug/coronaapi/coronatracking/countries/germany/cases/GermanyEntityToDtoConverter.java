package rug.coronaapi.coronatracking.countries.germany.cases;

import java.util.ArrayList;
import java.util.List;

public class GermanyEntityToDtoConverter {

    public static BundeslandCasesDto convertToDTO(GermanyCasesEntity casesEntity) {
        return new BundeslandCasesDto.Builder()
                .name(casesEntity.getBundeslandName())
                .recovered(casesEntity.getRecovered())
                .confirmed(casesEntity.getConfirmed())
                .date(casesEntity.getCasesUpdatedDate())
                .build();
    }

    public static List<BundeslandCasesDto> covertAllToDto(List<GermanyCasesEntity> germanyCasesEntities) {
        List<BundeslandCasesDto> bundeslandCasesDtos = new ArrayList<>();
        germanyCasesEntities.forEach(casesEntity -> bundeslandCasesDtos.add(convertToDTO(casesEntity)));
        return bundeslandCasesDtos;
    }
}
