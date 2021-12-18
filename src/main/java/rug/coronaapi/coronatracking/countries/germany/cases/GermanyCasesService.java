package rug.coronaapi.coronatracking.countries.germany.cases;

import org.springframework.stereotype.Service;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.Bundeslaender;

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
        Bundeslaender germanyCases = requestService.getGermanyCases();
        repository.save(converter.convertToEntity(germanyCases.getBayern()));
        repository.save(converter.convertToEntity(germanyCases.getBadenWurttemberg()));
        repository.save(converter.convertToEntity(germanyCases.getBerlin()));
        repository.save(converter.convertToEntity(germanyCases.getBrandenburg()));
        repository.save(converter.convertToEntity(germanyCases.getBremen()));
        repository.save(converter.convertToEntity(germanyCases.getBayern()));
        repository.save(converter.convertToEntity(germanyCases.getBayern()));
        repository.save(converter.convertToEntity(germanyCases.getBayern()));

    }


}
