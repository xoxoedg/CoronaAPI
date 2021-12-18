package rug.coronaApi.coronatracking.countries.germany.cases.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class BundeslandCases implements Serializable {
        protected BigInteger confirmed;
        protected BigInteger recovered;
        protected BigInteger deaths;
        protected LocalDate updated;
    }

