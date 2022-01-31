package com.prisonpony.assignment.test.specs

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount
import org.springframework.http.HttpStatus

import static com.prisonpony.assignment.test.data.Entities.aLoyaltyAccount

class AccountSpec extends AbstractSpec {

    def "all accounts should be retrievable via API"() {
        given:
        LoyaltyAccount account1 = aLoyaltyAccount()
        LoyaltyAccount account2 = aLoyaltyAccount()
        List<LoyaltyAccount> accounts = [account1, account2]

        and:
        databaseActor.withAccounts(accounts)

        expect:
        databaseActor.fetchAllRows("loyalty_account").size() == 2

        when:
        def response = apiActor.getAllAccounts()

        then:
        response.statusCode == HttpStatus.OK
        response.body.size() == 2
        response.body.find({ it.id == account1.id.toString() })
        response.body.find({ it.id == account2.id.toString() })
    }

}
