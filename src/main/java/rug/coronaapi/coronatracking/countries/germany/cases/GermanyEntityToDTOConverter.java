package rug.coronaapi.coronatracking.countries.germany.cases;

public class GermanyEntityToDTOConverter {

    public static GermanyCasesDTO convertToDTO(GermanyCasesEntity casesEntity) {
        return new GermanyCasesDTO.Builder()
                .name(casesEntity.getBundeslandName())
                .recovered(casesEntity.getRecovered())
                .confirmed(casesEntity.getConfirmed())
                .date(casesEntity.getCasesUpdatedDate())
                .build();
    }
}
