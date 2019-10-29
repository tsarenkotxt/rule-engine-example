# Easy Rules with Spring Boot
Simple example with [Rule Engine (easy-rules)](https://github.com/j-easy/easy-rules):
- save rules via REST API
    - save composite rules via REST API
- process entity through rules via REST API

### Requirements
***Java 11***

### Get started
#### Run Spring Boot application
```bash
./gradlew bootRun
```
#### Save simple rule
URL - ***http://localhost:8080/rules***             
HTTP Method - ***POST***
```json
{
  "name": "person rule 1",
  "description": "simple person rule for save",
  "priority": 1,
  "condition": "person.item.name == \"some item\"",
  "action": "savePerson"
}
```
#### Save composite rule
URL - ***http://localhost:8080/rules/composite***           
HTTP Method - ***POST***
```json
{
  "name": "composite person rule 1",
  "rules": [
    {
      "name": "person rule 2",
      "description": "simple person rule for send to vendor one",
      "priority": 1,
      "condition": "person.age > 10",
      "action": "sendPersonToVendorOne"
    },
    {
      "name": "person rule 3",
      "description": "simple person rule for send to vendor two",
      "priority": 1,
      "condition": "person.item.count == 1",
      "action": "sendPersonToVendorTwo"
    }
  ]
}
```
#### Process Person through rules
URL - ***http://localhost:8080/persons***               
HTTP Method - ***POST***
```json
{
  "name": "some name",
  "age": 18,
  "item": {
    "name": "some item",
    "count": 1
  }
}
```
> Response:
```json
{
  "person rule 1": true,
  "composite person rule 1": true
}
```
#### Get available actions
URL - ***http://localhost:8080/persons***               
HTTP Method - ***GET***         
> Response:
```json
[
  "savePerson",
  "sendPersonToVendorOne",
  "sendPersonToVendorTwo",
  "sendPersonToVendorThree"
]
```
#### Swagger UI
URL - ***http://localhost:8080/swagger-ui.html#/***     

