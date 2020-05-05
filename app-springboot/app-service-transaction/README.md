# app-service-transaction with Spring Boot

This project uses Spring Boot with connection to SQL Server.

## DOCKER jvm

  ### Packaging the application
    mvn clean
    mvn package 
 
  ###  execute app
    java -jar target/service-transaction-app-0.0.1-SNAPSHOT.jar

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



