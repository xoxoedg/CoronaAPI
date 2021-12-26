package rug.coronaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rug.coronaapi.germany.cases.GermanyCasesService;

@Component
public class Bootstrap implements CommandLineRunner {

    private final GermanyCasesService service;

    @Autowired
    public Bootstrap(GermanyCasesService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        service.saveTodayCases();
    }
}
