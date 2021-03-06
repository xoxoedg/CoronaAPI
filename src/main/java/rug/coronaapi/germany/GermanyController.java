package rug.coronaapi.germany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rug.coronaapi.germany.cases.BundeslandCasesDto;
import rug.coronaapi.germany.cases.GermanyCasesDto;
import rug.coronaapi.germany.cases.GermanyCasesService;
import rug.coronaapi.germany.vaccines.BundeslandVaccineDto;
import rug.coronaapi.germany.vaccines.GermanyVaccinesDto;
import rug.coronaapi.germany.vaccines.GermanyVaccinesService;

import java.util.List;

@RequestMapping("coronaapi/v1")
@RestController
public class GermanyController {

    private final GermanyCasesService casesService;
    private final GermanyVaccinesService vaccinesService;

    @Autowired
    public GermanyController(GermanyCasesService casesService, GermanyVaccinesService vaccinesService) {
        this.casesService = casesService;
        this.vaccinesService = vaccinesService;
    }


    @GetMapping("/germany/cases")
    public ResponseEntity<List<BundeslandCasesDto>> getAllCasesByBundesland() {
        return new ResponseEntity<>(casesService.findGermanyCasesToday(), HttpStatus.OK);
    }

    @GetMapping("/germany/cases/all")
    public ResponseEntity<GermanyCasesDto> getAllCases() {
        return new ResponseEntity<GermanyCasesDto>(casesService.findTotalCases(), HttpStatus.OK);
    }

    @GetMapping("/germany/bundesland/cases")
    public ResponseEntity<List<BundeslandCasesDto>> getCasesByBundesland(@RequestParam(name = "name") String bundesland) {
        return new ResponseEntity<>(casesService.findCaseByBundesland(bundesland), HttpStatus.OK);
    }

    @GetMapping("/germany/vaccines")
    public ResponseEntity<List<BundeslandVaccineDto>> getAllVaccines() {
        vaccinesService.saveTodayVaccines();
        return new ResponseEntity<>(vaccinesService.findGermanyVaccinesToday(), HttpStatus.OK);

    }

    @GetMapping("germany/bundesland/vaccines")
    public ResponseEntity<List<BundeslandVaccineDto>> getVaccinesByBundesland(@RequestParam(name = "name") String bundesland) {
        return new ResponseEntity<List<BundeslandVaccineDto>>(vaccinesService.findVaccinesByBundesland(bundesland), HttpStatus.OK);
    }

    @GetMapping("germany/vaccines/all")
    public ResponseEntity<GermanyVaccinesDto> getAllVaccinates() {
        return new ResponseEntity<>(vaccinesService.findTotalCases(), HttpStatus.OK);
    }


}
