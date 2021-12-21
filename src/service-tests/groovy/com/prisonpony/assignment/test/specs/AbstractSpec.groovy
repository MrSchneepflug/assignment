package com.prisonpony.assignment.test.specs

import com.prisonpony.assignment.test.actors.ApiActor
import com.prisonpony.assignment.test.actors.DatabaseActor
import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:/application-service-test.properties")
class AbstractSpec extends Specification {

    @LocalServerPort
    int port

    @Autowired
    ApiActor apiActor

    @Autowired
    DatabaseActor databaseActor

    @PostConstruct
    def init() {
        apiActor.init(port)
    }

    def setup() {
        databaseActor.deleteAllEntries("tickets")
    }
}
