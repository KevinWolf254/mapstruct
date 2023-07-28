# MAPSTRUCT
Project that show cases how to use map struct in a java 11 environment to reduce time spent on creating DTOs on your own.

## Introduction
MapStruct is a powerful code generation tool that simplifies the process of mapping data between different Java objects, such as DTOs (Data Transfer Objects) and domain objects. Using MapStruct in a Spring Boot application for DTO creation and avoiding exposing domain objects to the public offers several benefits:

## Benefits
- Separation of Concerns: MapStruct helps maintain a clear separation between your domain model and the data transfer model. It allows you to keep the domain objects focused on business logic and domain-specific behavior, while DTOs are designed specifically for data transfer between different layers of your application.

- Encapsulation and Information Hiding: By using DTOs, you can expose only the necessary data to the external world, providing better encapsulation and information hiding. This way, you can control what data is sent outside your application, protecting sensitive or unnecessary information from leaking.

- Reduced Risk of Overexposure: Exposing domain objects directly to the public can lead to unintentional data leaks and security vulnerabilities. With DTOs and MapStruct, you can fine-tune what data is exposed and avoid accidentally revealing sensitive internal information.

- Versioning and Compatibility: DTOs can act as stable contracts between different versions of your application or when dealing with external clients consuming your API. By using MapStruct, you can easily adapt and manage changes in the mapping logic if the DTO structure evolves.

- Reduced Boilerplate Code: MapStruct automates the process of mapping fields between DTOs and domain objects, saving you from writing tedious and error-prone boilerplate code. It generates efficient mapping code at compile-time based on annotations, making the mapping process more maintainable and less error-prone.

- Performance Optimization: MapStruct-generated code is highly optimized for mapping, which can result in better performance compared to manual mapping or other mapping frameworks. The generated code uses direct field access and efficient data conversions, leading to improved runtime efficiency.

- Testability: Separating the mapping logic into MapStruct interfaces makes it easier to test the mapping process independently, ensuring the correctness of the mapping logic.

## Prerequisites
To run this project locally, make sure you have the following installed:

- Java 11 
- Maven
- Your favorite IDE (IntelliJ, Eclipse, etc.) with Spring Boot support

NB: Does not work on Java 17

## Getting Started
1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Build the project using Maven.
4. Run the Spring Boot application.
5. The API should now be accessible at `http://localhost:7070`

## Usage
The API consists of several endpoints that allow you to perform typical CRUD (Create, Read, Update, Delete) operations on resources.

Here's a brief overview of the available endpoints:

### Companies

`POST /api/companies`: Creates a new company.

`Request`
```bash
curl -X POST -v http://localhost:7070/api/companies -H 'Content-Type: application/json' -d '{"id": "1", "name": "co-op bank" }' | json_pp
```
`Response`
```bash
{
   "id" : 1,
   "name" : "co-op bank"
}
```


`GET /api/companies`: Retrieves all companies.

`Request`
```bash
curl -v http://localhost:7070/api/companies | json_pp
```
`Response`
```bash
[
   {
      "id" : 1,
      "name" : "co-op bank"
   }
]
```


`GET /api/companies/1`: Fetches a specific company.

`Request`
```bash
curl -v http://localhost:7070/api/companies/1 | json_pp
```
`Response`
```bash
[
   {
      "id" : 1,
      "name" : "co-op bank"
   }
]
```


`PUT /api/companies/1`: Updates a customer and returns its details with hyperlinks.

`Request`
```bash
curl -X PUT -v http://localhost:7070/api/companies/1 -H 'Content-Type: application/json' -d '{"id": "1", "name": "co-op bank LTD"}' | json_pp
```
`Response`
```bash
{
   "id" : 1,
   "name" : "co-op bank LTD"
}
```


`DELETE /api/companies/1`: Deletes a customer.

`Request`
```bash
curl -X DELETE -v http://localhost:7070/api/companies/1 | json_pp
```
`Response`
```bash
```
### Employees

`POST /api/companies/{companyId}/employees`: Creates a new employee.

`Request`
```bash
curl -X POST -v http://localhost:7070/api/companies/1/employees -H 'Content-Type: application/json' -d '{"id": "1", "firstName": "Jeff","middleName": "Bezos", "lastName": "Goat", "companyId": "1" }' | json_pp
```
`Response`
```bash
{
   "companyId" : 1,
   "firstName" : "Jeff",
   "id" : 1,
   "lastName" : "Goat",
   "middleName" : "Bezos"
}
```


`GET /api/companies/{companyId}/employees`: Creates a new employee.

`Request`
```bash
curl -v http://localhost:7070/api/companies/1/employees | json_pp
```
`Response`
```bash
[
   {
      "companyId" : 1,
      "firstName" : "Jeff",
      "id" : 1,
      "lastName" : "Goat",
      "middleName" : "Bezos"
   }
]
```


`GET /api/companies/{companyId}/employees/{employeeId}`: Creates a new employee.

`Request`
```bash
curl -v http://localhost:7070/api/companies/1/employees/1 | json_pp
```
`Response`
```bash
{
    "companyId" : 1,
    "firstName" : "Jeff",
    "id" : 1,
    "lastName" : "Goat",
    "middleName" : "Bezos"
}
```


`PUT /api/companies/{companyId}/employees/{employeeId}`: Creates a new employee.

`Request`
```bash
curl -X PUT -v http://localhost:7070/api/companies/1/employees -H 'Content-Type: application/json' -d '{"id": "1", "firstName": "Jeff","middleName": "Bezos", "lastName": "Goatee", "companyId": "1" }' | json_pp
```
`Response`
```bash
{
    "companyId" : 1,
    "firstName" : "Jeff",
    "id" : 1,
    "lastName" : "Goatee",
    "middleName" : "Bezos"
}
```

`DELETE /api/companies/{companyId}/employees/{employeeId}`: Deletes a customer.

`Request`
```bash
curl -X DELETE -v http://localhost:7070/api/companies/1/employees/1 | json_pp
```
`Response`
```bash
```

## License
This project is licensed under the MIT License, which means you can use, modify, and distribute it freely. See the LICENSE file for more details.
