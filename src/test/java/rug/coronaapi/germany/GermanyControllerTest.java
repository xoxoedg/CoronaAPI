package rug.coronaapi.germany;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import rug.coronaapi.germany.cases.BundeslandCasesDto;
import rug.coronaapi.germany.cases.GermanyCasesDto;
import rug.coronaapi.germany.cases.GermanyCasesService;
import rug.coronaapi.germany.vaccines.GermanyVaccinesService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GermanyController.class)
class GermanyControllerTest {
    private final LocalDate testDate = LocalDate.of(2021, 12, 27);

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

    @Test
    void getCasesByBundesland() throws Exception {
        List<BundeslandCasesDto> casesByBundeslandDto = List.of(
                new BundeslandCasesDto.Builder().name("Thüringen")
                .date(testDate)
                .confirmed(1200L)
                .recovered(0L)
                .build(),
                new BundeslandCasesDto.Builder().name("Thüringen")
                .date(LocalDate.of(2021, 12,25))
                .confirmed(5000L)
                .recovered(0L)
                .build()
        );
        when(casesService.findCaseByBundesland(anyString())).thenReturn(casesByBundeslandDto);
        mockMv.perform(get("/coronaapi/v1/germany/bundesland/cases?name=Thüringen"))
            .andExpect(status().isOk())
            .andExpect(content().json("[{\"bundeslandName\":\"Thüringen\",\"recovered\":0,\"confirmed\":1200,\"casesUpdatedDate\":" +
                    "\"2021-12-27\"},{\"bundeslandName\":\"Thüringen\",\"recovered\":0,\"confirmed\":5000,\"casesUpdatedDate\":\"2021-12-25\"}]"));

    }

    @Test
    void testGetAllCases() throws Exception {
        GermanyCasesDto germanyCasesDto = new GermanyCasesDto.Builder().confirmed(111L).updated(testDate).build();
        when(casesService.findTotalCases()).thenReturn(germanyCasesDto);
        mockMv.perform(get("/coronaapi/v1/germany/cases/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"country\": \"Germany\", \"totalConfirmed\": 111,\"casesUpdatedDate\": \"2021-12-27\"}"));
    }
}