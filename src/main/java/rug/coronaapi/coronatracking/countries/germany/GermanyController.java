package rug.coronaapi.coronatracking.countries.germany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rug.coronaapi.coronatracking.countries.germany.cases.BundeslandCasesDto;
import rug.coronaapi.coronatracking.countries.germany.cases.GermanyCasesService;

import java.util.List;

@RequestMapping("coronaapi/v1")
@RestController
public class GermanyController {

    private final GermanyCasesService casesService;

    @Autowired
    public GermanyController(GermanyCasesService casesService) {
        this.casesService = casesService;
    }


    @GetMapping("/germany")
    public ResponseEntity<List<BundeslandCasesDto>> getAllCases() {
        casesService.saveTodayCases(); // probably in the service
        return new ResponseEntity<>(casesService.findGermanyCasesToday(), HttpStatus.OK);
    }

    @GetMapping("/germany")
    public ResponseEntity<List<BundeslandCasesDto>> getTodayCasesByBundesland(@RequestParam(name = "name") String bundesland) {
        return new ResponseEntity<List<BundeslandCasesDto>>(casesService.findCaseByBundesland(bundesland), HttpStatus.OK);
    }



}
