package com.prisonpony.assignment.test.actors

import groovy.json.JsonSlurper
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ApiActor {
    private String serviceUrl
    private final RestTemplate restTemplate = new RestTemplate()
    private final JsonSlurper jsonSlurper = new JsonSlurper()

    def init(int port) {
        this.serviceUrl = "http://localhost:" + port
    }

    Map getAllTickets() {
        ResponseEntity<String> response = restTemplate.exchange(
                serviceUrl + "/tickets",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class
        )

        return mapFromResponseEntity(response)
    }

    Map mapFromResponseEntity(ResponseEntity<String> responseEntity) {
        return [statusCode: responseEntity.getStatusCode(),
                headers   : responseEntity.getHeaders(),
                body      : responseEntity.getBody() ? jsonSlurper.parseText(responseEntity.getBody()) : responseEntity.getBody()]
    }
}
