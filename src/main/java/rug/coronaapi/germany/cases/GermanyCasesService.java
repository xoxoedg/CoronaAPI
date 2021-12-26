package rug.coronaapi.germany.cases;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rug.coronaapi.Validation.BundeslandValidation;
import rug.coronaapi.germany.cases.mapping.Bundeslaender;
import rug.coronaapi.germany.exception.BundeslandNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class GermanyCasesService {


    private final GermanyCasesRepository repository;
    private final GermanyCasesRequestService requestService;

    public GermanyCasesService(GermanyCasesRepository repository,
                               GermanyCasesRequestService requestService) {
        this.repository = repository;
        this.requestService = requestService;
    }


    public void saveTodayCases() {

        if (repository.findByCasesUpdatedDate(LocalDate.now()).size() == 0) {
            Bundeslaender germanyCases = requestService.getGermanyCases();
            repository.saveAll(GermanyCasesApiToEntityConverter.covertAllToEntity(germanyCases));

        } else log.info("Cases already in Database");
    }

    public List<BundeslandCasesDto> findGermanyCasesToday() {
        return GermanyEntityToDtoConverter.covertAllToDto(repository.findByCasesUpdatedDate(LocalDate.now()));
    }

    public List<BundeslandCasesDto> findCaseByBundesland(String name) {
        if (BundeslandValidation.validate(name)) {
            return GermanyEntityToDtoConverter.covertAllToDto(repository.findByBundeslandName(name));
        } else throw new BundeslandNotFoundException("Invalid Bundesland");
    }
}
