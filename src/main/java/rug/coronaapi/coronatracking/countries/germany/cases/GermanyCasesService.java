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
        if (findGermanyCasesToday() == null) {
            Bundeslaender germanyCases = requestService.getGermanyCases();
            List<GermanyCasesEntity> germanyCasesEntities = List.of(converter.convertToEntity(germanyCases.getBayern()), converter.convertToEntity(germanyCases.getBadenWurttemberg()), converter.convertToEntity(germanyCases.getBerlin()),
                    converter.convertToEntity(germanyCases.getBrandenburg()), converter.convertToEntity(germanyCases.getBremen()),
                    converter.convertToEntity(germanyCases.getHamburg()), converter.convertToEntity(germanyCases.getHessen()),
                    converter.convertToEntity(germanyCases.getMecklenburgVorpommern()), converter.convertToEntity(germanyCases.getNiedersachsen()),
                    converter.convertToEntity(germanyCases.getNordrheinWestfalen()), converter.convertToEntity(germanyCases.getSaarland()),
                    converter.convertToEntity(germanyCases.getSachsen()), converter.convertToEntity(germanyCases.getSachsenAnhalt()),
                    converter.convertToEntity(germanyCases.getSchleswigHolstein()), converter.convertToEntity(germanyCases.getThuringen()));

            germanyCasesEntities.forEach(repository::save);
        }
        log.info("Cases already in Database");
    }

    public List<BundeslandCasesDTO> findGermanyCasesToday() {
        List<BundeslandCasesDTO> bundeslandCasesDTO = new ArrayList<>();
        repository.findByCasesUpdatedDate(LocalDate.of(2021, 12, 18)).forEach(entity -> bundeslandCasesDTO.add(GermanyEntityToDTOConverter.convertToDTO(entity)));
        return bundeslandCasesDTO;
    }

    public List<BundeslandCasesDTO> findCaseByBundesland(String name) {
        List<BundeslandCasesDTO> bundeslandCasesDTOS = new ArrayList<>();
        repository.findByBundeslandName(name).forEach(entity -> bundeslandCasesDTOS.add(GermanyEntityToDTOConverter.convertToDTO(entity)));
        return bundeslandCasesDTOS;
    }


}
