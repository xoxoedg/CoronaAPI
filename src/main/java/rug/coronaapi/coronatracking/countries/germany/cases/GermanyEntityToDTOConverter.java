package rug.coronaapi.coronatracking.countries.germany.cases;

public class GermanyEntityToDTOConverter {

    public static BundeslandCasesDTO convertToDTO(GermanyCasesEntity casesEntity) {
        return new BundeslandCasesDTO.Builder()
                .name(casesEntity.getBundeslandName())
                .recovered(casesEntity.getRecovered())
                .confirmed(casesEntity.getConfirmed())
                .date(casesEntity.getCasesUpdatedDate())
                .build();
    }
}
