# Sales Taxes Application
[![Build Status](https://travis-ci.org/fjdearcos/salestaxes.svg?branch=master)](https://travis-ci.org/fjdearcos/salestaxes) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes) [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes) [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=security_rating)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=coverage)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=es.fjdearcos%3Asalestaxes&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=es.fjdearcos%3Asalestaxes)

Application to calculate the price of a purchase including the taxes

## Motivation

Pet Project to demonstrate my current code style and skills paying particular attention to:
- Clean code and SOLID principles
- Use of design patterns
- Automated testing

To develop this application I have used the following technologies:
- Java 8
- Lombok to create POJO Value classes avoiding boilerplate code
- Spring to implement dependency injection
- JUnit and Mockito for Unit Testing
- Maven to build and manage project dependencies
- Travis CI to provide Continuous Integration
- SonarCloud to provide code quality analysis 

## Prerequisites

This software must be installed to compile and run the application:
- Java 8
- Maven

## Getting started

### Building

To build the project you should use Maven:

```shell
mvn clean package
```

### Running

To run the Sales Taxes console application:

```shell
java -jar target/salestaxes-1.0.0-jar-with-dependencies.jar
```

### Using the application

Once the application is running you should write a valid purchase description in the console item by item with the following format:
```
[Number of items] [product description specifying if it is a imported product] at [price with two decimals]
```
When you finish creating your purchase you should enter an empty line and see the generated receipt in the console.

The [Sales Taxes Application IT tests](src/test/java/es/fjdearcos/salestaxes/SalesTaxesApplicationIT.java) contains examples of valid inputs and expected outputs.

## Features

Calculate the total amount of taxes in a purchase and per item using the following rules:
- Basic sales tax at a rate of 10% on all goods except books, food and medical products.
- Import duty at a rate of 5% on all imported goods with no exemptions.
- Taxes are rounded to the nearest 0.05

## Software Design

### High Level Design
At a high level of abstraction, this software has been develop following the Hexagonal Architecture, also known as Ports and Adapters Architecture. I have chosen this architectural pattern to keep the different components needed loosely coupled, and so, to make it exchangeable and to ease testing, improving scalability. 

Following this principles you can protect the business logic from being coupled to a specific framework, consuming technology as REST or a database implementation. All of those are details that are connected through the defined ports, and you can change them easily whenever you need it.

### Low Level Design
At a low level, this software follows the SOLID principles and Clean Code best practices, trying to keep code easy to read, maintain and scale.

## Contributing

To contribute to the project you may start with the following commands:

```shell
git clone https://github.com/fjdearcos/salestaxes
cd salestaxes/
mvn clean package
```

Any feedback and suggestions creating an issue or pull request will be highly appreciated

## Licensing

The code in this project is licensed under MIT License [LICENSE](LICENSE)

