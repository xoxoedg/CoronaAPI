package rug.coronaapi.coronatracking.countries.germany.cases;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rug.coronaapi.coronatracking.countries.germany.cases.mapping.Bundeslaender;

@Service
public class GermanyCasesRequestService {

    private final RestTemplate restTemplate;

    public GermanyCasesRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Bundeslaender getGermanyCases() {
        return restTemplate.getForObject("https://covid-api.mmediagroup.fr/v1/cases?country=Germany",
                Bundeslaender.class);

    }

}
