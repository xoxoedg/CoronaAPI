package rug.coronaapi.germany.vaccines;

import java.util.ArrayList;
import java.util.List;

public class BundeslandEntityToDtoConverter {

    public static BundeslandVaccineDto convertToDto(GermanyVaccinesEntity entity) {
        return new BundeslandVaccineDto.Builder()
                .name(entity.getBundeslandName())
                .vaccinated(entity.getFullyVaccinated())
                .date(entity.getVaccinesUpdatedDate())
                .build();
    }

    public static List<BundeslandVaccineDto> convertAllToDto(List<GermanyVaccinesEntity> vaccinesEntities) {
        List<BundeslandVaccineDto> bundeslandVaccineDtos = new ArrayList<>();
        vaccinesEntities.forEach(
                vaccinesEntity -> bundeslandVaccineDtos.add(convertToDto(vaccinesEntity)));
        return bundeslandVaccineDtos;
    }
}
