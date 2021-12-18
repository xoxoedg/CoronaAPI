package rug.coronaapi.coronatracking.countries.germany;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rug.coronaapi.coronatracking.countries.germany.cases.GermanyCasesDTO;

@RequestMapping("coronaapi/v1")
@RestController
public class GermanyController {

    @GetMapping("/germany")
    public GermanyCasesDTO getAllCases() {
        return new GermanyCasesDTO();
    }

    @GetMapping("/germany/")
    public GermanyCasesDTO getCasesByBundesland(@RequestParam(name = "name") String Bundesland) {
        return new GermanyCasesDTO();
    }



}
