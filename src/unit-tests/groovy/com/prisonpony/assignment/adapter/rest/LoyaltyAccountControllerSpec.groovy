package com.prisonpony.assignment.adapter.rest

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount
import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccountRepository
import com.prisonpony.assignment.adapter.rest.LoyaltyAccountController
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Subject

import static com.prisonpony.assignment.test.data.Entities.aLoyaltyAccount

class LoyaltyAccountControllerSpec extends Specification {

    LoyaltyAccountRepository repository = Mock()

    @Subject
    LoyaltyAccountController controller = new LoyaltyAccountController(repository)

    def "it should return a list of accounts"() {
        given:
        LoyaltyAccount account1 = aLoyaltyAccount()
        LoyaltyAccount account2 = aLoyaltyAccount()
        List<LoyaltyAccount> accounts = [account1, account2]

        and:
        repository.findAll() >> accounts

        when:
        ResponseEntity<List<LoyaltyAccount>> response = controller.getAccounts()

        then:
        response.body.size() == 2
        response.body.find({ it.id == account1.id })
        response.body.find({ it.id == account2.id })
    }

}
