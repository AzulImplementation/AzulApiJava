# AzulApiJava

[![codecov](https://codecov.io/gh/AzulImplementation/AzulApiJava/branch/main/graph/badge.svg)](https://codecov.io/gh/AzulImplementation/AzulApiJava)

## Using the API

Download the jar file from [https://github.com/AzulImplementation/AzulApiJava/releases](releases).

Execute: `java -jar target/azulapi.jar <number of players (from 2 to 4)>`.

# Running the API with Maven

If you have Maven installed you can use: `mvn spring-boot:run "-Dspring-boot.run.arguments=<number of players (from 2 to 4)>"`

or:

```
mvn clean package
java -jar target/azulapi.jar <number of players (from 2 to 4)>
```