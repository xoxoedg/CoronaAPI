package rug.coronaapi.countries.germany.vaccines;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rug.coronaapi.countries.germany.vaccines.mapping.Bundeslaender;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class GermanyVaccinesService {

    private final GermanyVaccinesRepository vaccinesRepository;
    private final GermanyVaccinesRequestService vaccinesRequestService;

    public GermanyVaccinesService(GermanyVaccinesRepository vaccinesRepository, GermanyVaccinesRequestService vaccinesRequestService) {
        this.vaccinesRepository = vaccinesRepository;
        this.vaccinesRequestService = vaccinesRequestService;
    }

    public void saveTodayVaccines() {
        if (vaccinesRepository.findAll().size() == 0) {
            Bundeslaender germanyVaccines = vaccinesRequestService.getGermanyVaccines();
            GermanyVaccinesApiToEntityConverter.convertAllToEntity(germanyVaccines);
        } else log.info("Cases already in Database");
    }

    public List<BundeslandVaccineDto> findGermanyVaccinesToday() {
        return BundeslandEntityToDtoConverter.convertAllToDto(vaccinesRepository.findByVaccinesUpdatedDate(LocalDate.now()));
    }

    public List<BundeslandVaccineDto> findVaccinesByBundesland(String name) {
        return BundeslandEntityToDtoConverter.convertAllToDto(vaccinesRepository.findByBundeslandName(name));
    }


}

