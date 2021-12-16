package rug.coronaApi.CoronaTracking.Countries.GermanyData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class Bundesland implements Serializable {
        protected String name = "Whatever";
        protected boolean confirmed;
        protected int recovered;
        protected int deaths;
        @DateTimeFormat
        protected  String updated;
    }

