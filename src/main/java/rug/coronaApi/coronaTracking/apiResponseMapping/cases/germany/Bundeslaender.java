package rug.coronaApi.coronaTracking.apiResponseMapping.cases.germany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class Bundeslaender implements Serializable {
    @JsonProperty("Baden-Wurttemberg")
    public BadenWurttemberg badenWurttemberg;
    @JsonProperty("Bayern")
    public Bayern bayern;
    @JsonProperty("Berlin")
    public Berlin berlin;
    @JsonProperty("Brandenburg")
    public Brandenburg brandenburg;
    @JsonProperty("Bremen")
    public Bremen bremen;
    @JsonProperty("Hamburg")
    public Hamburg hamburg;
    @JsonProperty("Hessen")
    public Hessen hessen;
    @JsonProperty("Mecklenburg-Vorpommern")
    public MecklenburgVorpommern mecklenburgVorpommern;
    @JsonProperty("Niedersachsen")
    public Niedersachsen niedersachsen;
    @JsonProperty("Nordrhein-Westfalen")
    public NordrheinWestfalen nordrheinWestfalen;
    @JsonProperty("Rheinland-Pfalz")
    public RheinlandPfalz rheinlandPfalz;
    @JsonProperty("Saarland")
    public Saarland saarland;
    @JsonProperty("Sachsen")
    public Sachsen sachsen;
    @JsonProperty("Sachsen-Anhalt")
    public SachsenAnhalt sachsenAnhalt;
    @JsonProperty("Schleswig-Holstein")
    public SchleswigHolstein schleswigHolstein;
    @JsonProperty("Thuringen")
    public Thuringen thuringen;
}
