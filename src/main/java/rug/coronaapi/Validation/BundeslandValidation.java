package rug.coronaapi.Validation;

import java.util.List;

public class BundeslandValidation {

    private final static List<String> validBundesländer =
            List.of("bayern", "badenwürttemberg", "berlin", "brandenburg", "bremen", "hamburg",
                    "hessen", "mecklenburgvorpommern, niedersachsen", "nordrheinwestfalen",
                    "saarland", "sachsen", "sachsenanhalt", "schleswigholstein", "thüringen");

    public static boolean validate(String bundeslandName) {
        return validBundesländer.contains(bundeslandName.toLowerCase());
    }
}
