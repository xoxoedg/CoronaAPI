package rug.coronaapi.germany.cases;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rug.coronaapi.germany.cases.mapping.Bundeslaender;

@Service
public class GermanyCasesRequestService {

    private final RestTemplate restTemplate;

    public GermanyCasesRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //ApiResponseHandler
    public Bundeslaender getGermanyCases() {
        return restTemplate.getForObject("https://covid-api.mmediagroup.fr/v1/cases?country=Germany",
                Bundeslaender.class);
    }
}
