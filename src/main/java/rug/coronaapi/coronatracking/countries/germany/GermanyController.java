package rug.coronaapi.coronatracking.countries.germany;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rug.coronaapi.coronatracking.countries.germany.cases.BundeslandCasesDTO;
import rug.coronaapi.coronatracking.countries.germany.cases.GermanyCasesService;

import java.util.List;

@RequestMapping("coronaapi/v1")
@RestController
public class GermanyController {

    private final GermanyCasesService casesService;

    public GermanyController(GermanyCasesService casesService) {
        this.casesService = casesService;
    }


    @GetMapping("/germany")
    public List<BundeslandCasesDTO> getAllCases() {
        casesService.saveTodayCases();
        casesService.findGermanyCasesToday().forEach(x -> System.out.println(x.toString()));
        return casesService.findGermanyCasesToday();
    }

    @GetMapping("/germany/")
    public BundeslandCasesDTO getCasesByBundesland(@RequestParam(name = "name") String Bundesland) {
        return new BundeslandCasesDTO();
    }



}
