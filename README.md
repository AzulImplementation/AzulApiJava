# AzulApiJava

An API to play [Azul board game](https://en.wikipedia.org/wiki/Azul_(board_game)).

## Using the API

Download the jar file from [releases](https://github.com/AzulImplementation/AzulApiJava/releases).

Execute: `java -jar target/azulapi.jar <number of players (from 2 to 4)> --server.port=<port, if not entered 8080 will be used>`.

## Running the API with Maven

`mvn spring-boot:run "-Dspring-boot.run.arguments=<number of players (from 2 to 4)> --server.port=<port, if not entered 8080 will be used>"`

or:

```
mvn package
java -jar target/azulapi.jar <number of players (from 2 to 4) --server.port=<port, if not entered 8080 will be used>>
```

## Functionality

To access the functionality documentation please run the service and visit `/swagger-ui/index.html` endpoint.

Alternatively read `GameController.java`, `FactoryTakingRequest.java` and `CenterTakingRequest.java` classes which have Swagger documentation.

## Running the tests with Maven

```mvn test```

[![codecov](https://codecov.io/gh/AzulImplementation/AzulApiJava/branch/main/graph/badge.svg)](https://codecov.io/gh/AzulImplementation/AzulApiJava)

## License

Please read a `LICENSE` file.