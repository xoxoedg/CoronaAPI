package rug.coronaapi.germany.vaccines;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rug.coronaapi.germany.vaccines.mapping.Bundeslaender;

@Service
public class GermanyVaccinesRequestService {

    private final RestTemplate restTemplate;

    public GermanyVaccinesRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Bundeslaender getGermanyVaccines() {
        return restTemplate.getForObject("https://covid-api.mmediagroup.fr/v1/vaccines?country=Germany", Bundeslaender.class);
    }
}
