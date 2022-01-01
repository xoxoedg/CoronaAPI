# Cases Data
API for checking Corona Cases/Vaccines


1. **Cases Endpoints:**

1.1 Description:

- Returns the overall Count of cases for today

1.2 Example Request:

- GET /germany/all


1.3 Example Response

```
{
    "country": "Germany",
    "totalConfirmed": 6897135,
    "casesUpdatedDate": "2022-01-01"
}
```

1.4 Description:

- Returns all cases for today splitted by Bundesland


1.5 Example Request:

 - GET /germany/cases

1.6 Example Response:

```
[
    {
        "bundeslandName": "Bayern",
        "recovered": 0,
        "confirmed": 1331261,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Baden Württemberg",
        "recovered": 0,
        "confirmed": 1021855,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Berlin",
        "recovered": 0,
        "confirmed": 331233,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Brandenburg",
        "recovered": 0,
        "confirmed": 244380,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Bremen",
        "recovered": 0,
        "confirmed": 48483,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Hamburg",
        "recovered": 0,
        "confirmed": 141452,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Hessen",
        "recovered": 0,
        "confirmed": 481831,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Mecklenburg Vorpommern",
        "recovered": 0,
        "confirmed": 101242,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Niedersachsen",
        "recovered": 0,
        "confirmed": 443516,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Nordrhein Westfalen",
        "recovered": 0,
        "confirmed": 1386725,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Saarland",
        "recovered": 0,
        "confirmed": 74409,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Sachsen",
        "recovered": 0,
        "confirmed": 653979,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Sachsen Anhalt",
        "recovered": 0,
        "confirmed": 225963,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Schleswig Holstein",
        "recovered": 0,
        "confirmed": 120034,
        "casesUpdatedDate": "2022-01-01"
    },
    {
        "bundeslandName": "Thüringen",
        "recovered": 0,
        "confirmed": 290772,
        "casesUpdatedDate": "2022-01-01"
    }
]
```

1.7 Description:

- Returns Data by Bundesland (returns data for all dates saved in Mysql Database)

1.8 Example Request

- GET germany/bundesland/cases?name=Bayern
- Query Parameter (Bundesland)
 
1.9 Example Response:


```
[
    {
        "bundeslandName": "Bayern",
        "recovered": 0,
        "confirmed": 1308233,
        "casesUpdatedDate": "2021-12-26"
    },
    {
        "bundeslandName": "Bayern",
        "recovered": 0,
        "confirmed": 1328017,
        "casesUpdatedDate": "2021-12-31"
    },
    {
        "bundeslandName": "Bayern",
        "recovered": 0,
        "confirmed": 1331261,
        "casesUpdatedDate": "2022-01-01"
    }
]
```

# Vaccines Data

work in progress















