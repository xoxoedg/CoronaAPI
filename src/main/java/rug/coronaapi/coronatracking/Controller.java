package rug.coronaapi.coronatracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.Bundeslaender;

@RestController
public class Controller {


    private final RestTemplate template;

    @Autowired
    public Controller(RestTemplate template) {
        this.template = template;
    }

    @GetMapping("/")
    public Bundeslaender getData() {
        Bundeslaender bundeslaender = template.getForObject("https://covid-api.mmediagroup.fr/v1/cases?country=Germany", Bundeslaender.class);
    return bundeslaender;
    }
}
