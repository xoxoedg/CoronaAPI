package rug.coronaapi.coronatracking.countries.germany.cases;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.Bundeslaender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GermanyCasesService {

    private final GermanyApiToEntityConverter converter;
    private final GermanyCasesRepository repository;
    private final GermanyCasesRequestService requestService;

    public GermanyCasesService(GermanyApiToEntityConverter converter, GermanyCasesRepository repository,
                               GermanyCasesRequestService requestService) {
        this.converter = converter;
        this.repository = repository;
        this.requestService = requestService;
    }

    public void saveTodayCases() {
        if (repository.findByCasesUpdatedDate(LocalDate.now()) == null) {
            Bundeslaender germanyCases = requestService.getGermanyCases();
            repository.saveAll(converter.covertAllToEntity(germanyCases));


        }
        else log.info("Cases already in Database");
    }

    public List<BundeslandCasesDto> findGermanyCasesToday() {
        List<BundeslandCasesDto> bundeslandCasesDTO = new ArrayList<>();
        repository.findByCasesUpdatedDate(LocalDate.of(2021, 12, 19)).forEach(entity -> bundeslandCasesDTO.add(GermanyEntityToDtoConverter.convertToDTO(entity)));
        return bundeslandCasesDTO;
    }

    public List<BundeslandCasesDto> findCaseByBundesland(String name) {
        return GermanyEntityToDtoConverter.covertAllToDto(repository.findByBundeslandName(name));
    }
}
