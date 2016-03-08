# Text REST Service with Elastic Search support
This application provides a REST interface that allows CRUD and search functionality on text entities.

# Requirements
- Java 1.8 Runtime
- Maven

# Start REST service
- Browse to the root project containing the `pom.xml` file
- Start the server by executing `mvn spring-boot:run`

When the server started successfully, you should see the following message:
`Tomcat started on port(s): 8080 (http)`

# CRUD actions
- Create a new text:

Send a POST request to http://localhost:8080/text with, for example, the following body
```javascript
{
    "title": "Test title",
    "content": "Test Content",
    "score": 4
}
```

- Update an existing text:

Send a PUT request to http://localhost:8080/text with, for example, the following body
```javascript
{
    "id": "AVNVk1Ebt4z2On7hAeGI",
    "title": "Test modified title",
    "content": "Some modified text",
    "score": 10
}
```
- List all texts:

Send a GET request to http://localhost:8080/text

- Find one text:

Send a GET request to http://localhost:8080/text/[ID]. For example in the previous test, you'd request http://localhost:8080/text/AVNVk1Ebt4z2On7hAeGI

- Remove an existing text:

Send a DELETE request to http://localhost:8080/text/[ID]. For example in the previous test, you'd request http://localhost:8080/text/AVNVk1Ebt4z2On7hAeGI

# Searching texts
- Request a basic fuzzy search (`analyze_wildcard` set to `true`) on the texts (content and title):

Send a GET request to http://localhost:8080/text/search/ome+odifie+ex/. Mind the trailing slash. 