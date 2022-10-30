# Cinema REST application

This is simple application which works with REST.

You are the owner or small cinema hall (9 rows & 9 columns) and by using some request you can book tickets and see statistic.

### Endpoints in the app:

- **GET /seats** -> you will see the schema of hall with available seats;

- **POST /purchase** -> to buy one of available tickets


    body (json):

    {
        "row": 1,
        "column": 1
    } 

- **POST /return** -> to return ticket (you need to copy the token when buy one)


    body (json):

    {
        "token":"b0ec7e04-61c0-4679-bd55-9cedb787d371"
    }

- **GET /stats** - > to see the statistic of current income, tickets available and so on. To see statistic use the secret below


    params: 

    password=super_secret

### Tom Shandrikov, 30.10.2022