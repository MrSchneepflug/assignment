package com.prisonpony.assignment.adapter.persistence.jpa

import com.prisonpony.assignment.adapter.rest.LoyaltyPointController
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Subject

import static com.prisonpony.assignment.test.data.Entities.aLoyaltyAccount

class LoyaltyAccountControllerSpec extends Specification {

    TicketRepository repository = Mock()

    @Subject
    LoyaltyPointController controller = new LoyaltyPointController(repository)

    def "it should return a list of tickets"() {
        given:
        Ticket ticket1 = aTicket()
        Ticket ticket2 = aTicket()
        List<Ticket> tickets = [ticket1, ticket2]

        and:
        repository.findAll() >> tickets

        when:
        ResponseEntity<List<LoyaltyAccount>> response = controller.getAccounts()

        then:
        response.body.size() == 2
        response.body.find({ it.id == ticket1.id })
        response.body.find({ it.id == ticket2.id })
    }

}
