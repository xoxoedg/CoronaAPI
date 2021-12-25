package rug.coronaapi.countries.germany.vaccines;

import java.util.ArrayList;
import java.util.List;

public class BundeslandEntityToDtoConverter {

    public BundeslandVaccineDto convertToDto(GermanyVaccinesEntity entity) {
        return new BundeslandVaccineDto.Builder()
                .name(entity.getBundeslandName())
                .vaccinated(entity.getFullyVaccinated())
                .date(entity.getVaccinesUpdatedDate())
                .build();
    }

    public List<BundeslandVaccineDto> convertAllToDto(List<GermanyVaccinesEntity> vaccinesEntities) {
        List<BundeslandVaccineDto> bundeslandVaccineDtos = new ArrayList<>();
        vaccinesEntities.forEach(vaccinesEntity -> bundeslandVaccineDtos.add(convertToDto(vaccinesEntity)));
        return bundeslandVaccineDtos;
    }
}
