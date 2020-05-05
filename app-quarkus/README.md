# app-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## DOCKER jvm

  ### Packaging the application
    mvn clean
    mvn package 
    
  ### USING DOCKER
    docker pull mcr.microsoft.com/mssql/server:2019-GA-ubuntu-16.04
    docker volume create volumeSqlServer
    docker run  --net=app-quarkus-bridge -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Password123#" -p 1433:1433 -v volumeSqlServer:/var/opt/mssql -d mcr.microsoft.com/mssql/server:2019-GA-ubuntu-16.04

  ### USING DOCKER COMPOSE
    docker-compose up sqlserver app-quarkus-native

 Execute script (tables) -> sql/schema.sql

## DOCKER native

   ### Install graalvm
   
     sdk list java
     sdk install java 20.0.0.r11-grl
     sdk use java 20.0.0.r11-grl
     --add path grallvm
     export GRAALVM_HOME=/<PATH>/java/20.0.0.r11-grl/
     ${GRAALVM_HOME}/bin/gu install native-image
   
   ### Packaging the application
     mvn clean
     mvn package -Pnative -Dquarkus.native.container-build=true

   ### USING DOCKER COMPOSE
     docker-compose up sqlserver app-quarkus-native
   
## Example request

    {
      "beneficiary": {
        "document": {
          "id": "70006676",
          "type": "DNI"
        },
        "firstName": "LUIS",
        "firstSurname": "GOMEZ",
        "secondName": "SAAVEDRA",
        "secondSurname": "string"
      },
      "billing": {   
        "invoicing": [
          {
            "amount": {
              "amount": 100,
              "currencyCode": "PEN"
            },
            "billingType": "TODO"
          }
        ],
        "payments": [
          {
            "amount": {
              "amount": 100,
              "currencyCode": "PEN"
            },
            "paymentType": "CASH"
          }
        ]
      },
      "creditcard": {
        "id": "1007002778427",
        "type": "MASTERCARD"
      },
      "internalOperationCode": "0001",
      "tokenHostname": "@HOST",
      "tokenStoreCode": "888",
      "tokenUserName": "TK0342"
    }


    Example GET: 
    
    curl -X GET "http://localhost:8080/credit-card/193358e1-d03c-0bd4-80a0-1b2000111319/get" -H "accept: application/json"


## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/app-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.





