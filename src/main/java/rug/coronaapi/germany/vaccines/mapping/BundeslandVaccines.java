package rug.coronaapi.germany.vaccines.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public abstract class BundeslandVaccines {
    private String name;
    private Long administered;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDateTime updated;


}

