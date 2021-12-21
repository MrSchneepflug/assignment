package com.prisonpony.assignment.test.specs

import static com.prisonpony.assignment.test.data.Entities.aTicket

import com.prisonpony.assignment.adapter.persistence.jpa.Ticket
import org.springframework.http.HttpStatus

class TicketSpec extends AbstractSpec {

    def "all tickets should be retrievable via API"() {
        given:
        Ticket ticket1 = aTicket()
        Ticket ticket2 = aTicket()
        List<Ticket> tickets = [ticket1, ticket2]

        and:
        databaseActor.withTickets(tickets)

        expect:
        databaseActor.fetchAllRows("tickets").size() == 2

        when:
        def response = apiActor.getAllTickets()

        then:
        response.statusCode == HttpStatus.OK
        response.body.size() == 2
        response.body.find({ it.id == ticket1.id.toString() })
        response.body.find({ it.id == ticket2.id.toString() })
    }

}
