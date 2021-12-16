package rug.coronaApi.coronaTracking.apiResponseMapping.cases.germany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class Bundesland implements Serializable {
        protected String name = "Whatever";
        protected BigInteger confirmed;
        protected BigInteger recovered;
        protected BigInteger deaths;
        protected LocalDate updated;
    }

