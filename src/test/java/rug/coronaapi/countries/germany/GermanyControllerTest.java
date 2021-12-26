package rug.coronaapi.countries.germany;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import rug.coronaapi.countries.germany.cases.BundeslandCasesDto;
import rug.coronaapi.countries.germany.cases.GermanyCasesService;
import rug.coronaapi.countries.germany.vaccines.GermanyVaccinesService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GermanyController.class)
class GermanyControllerTest {

    @Autowired
    MockMvc mockMv;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GermanyCasesService casesService;

    @MockBean
    GermanyVaccinesService vaccinesService;

    @Test
    void getAllCases() throws Exception {
        LocalDate testDate = LocalDate.of(2021, 12, 27);
        List<BundeslandCasesDto> casesDtos = List.of(
                new BundeslandCasesDto.Builder()
                        .name("Bayern")
                        .confirmed(1200L)
                        .recovered(0L)
                        .date(testDate)
                        .build(),
                new BundeslandCasesDto.Builder()
                        .name("Hessen")
                        .confirmed(1500L)
                        .recovered(0L)
                        .date(testDate)
                        .build());

        when(casesService.findGermanyCasesToday()).thenReturn(casesDtos);

        mockMv.perform(get("/coronaapi/v1/germany/cases"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"bundeslandName\":\"Bayern\",\"recovered\":0,\"confirmed\":1200,\"casesUpdatedDate\":\"2021-12-27\"}" +
                        ",{\"bundeslandName\":\"Hessen\",\"recovered\":0,\"confirmed\":1500,\"casesUpdatedDate\":\"2021-12-27\"}]"));
    }
}