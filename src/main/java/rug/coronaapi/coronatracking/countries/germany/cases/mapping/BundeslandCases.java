package rug.coronaapi.coronatracking.countries.germany.cases.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BundeslandCases implements Serializable {
    protected String name;
    protected Long confirmed;
    protected Long recovered;
    protected Long deaths;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updated;
}

