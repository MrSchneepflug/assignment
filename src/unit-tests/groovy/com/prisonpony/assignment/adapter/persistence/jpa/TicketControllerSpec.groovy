package com.prisonpony.assignment.adapter.persistence.jpa

import static com.prisonpony.assignment.test.data.Entities.aTicket

import com.prisonpony.assignment.adapter.rest.TicketController
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Subject

class TicketControllerSpec extends Specification {

    TicketRepository repository = Mock()

    @Subject
    TicketController controller = new TicketController(repository)

    def "it should return a list of tickets"() {
        given:
        Ticket ticket1 = aTicket()
        Ticket ticket2 = aTicket()
        List<Ticket> tickets = [ticket1, ticket2]

        and:
        repository.findAll() >> tickets

        when:
        ResponseEntity<List<Ticket>> response = controller.getTickets()

        then:
        response.body.size() == 2
        response.body.find({ it.id == ticket1.id })
        response.body.find({ it.id == ticket2.id })
    }

}
