# Demo 3 Logics RESTful API

1. Permutations
2. Find ODD Number
3. Count Smileys Faces

## Prerequire

- Java 17+
- Maven
- Docker (If run on Docker)

## API Design

|  API Name| API URL  | Permission | HTTP Method | Example Value |
|---|---|---|---|---|
|  Permutations | http://localhost:8888/api/permutation/{string} | All | GET | /abc |
|  Find ODD Number | http://localhost:8888/api/findoddint | All | POST | [0,1,2,3] |
| Count Smileys Faces | http://localhost:8888/api/countsmileys | All| POST | [":)", ";(", ";}", ":-D"] |

## API Response

```json
{
    "message":"Successfully",
    "status":"success",
    "data":["abc","acb","bac","bca","cab","cba"],
    "code":"200",
}
```

## API Error Response

```json
{
    "guid": "5ab4dd62-e4c7-4934-bc52-01324bbed5cc",
    "errorCode": "500",
    "message": "Handler dispatch failed: java.lang.OutOfMemoryError: Java heap space",
    "statusCode": 500,
    "statusName": "INTERNAL_SERVER_ERROR",
    "path": "/permutation/..32584DDW+++",
    "method": "GET",
    "timestamp": "2023-11-20T15:24:40.814142"
}
```

## Run on local with Maven

`mvn spring-boot:run` 

## Run on local with Docker

`../docker-compose up -d`

## Default URL

http://localhost:8888/api

## Swagger URL

http://localhost:8888/api/swagger-ui/index.html

