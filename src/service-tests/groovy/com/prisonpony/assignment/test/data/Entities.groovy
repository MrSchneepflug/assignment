package com.prisonpony.assignment.test.data

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount

class Entities {

    static LoyaltyAccount aLoyaltyAccount(Map params = [:]) {
        Map values = [
                id          : UUID.randomUUID(),
                customerUuid: UUID.randomUUID(),
                points      : 10,
        ] << params

        new LoyaltyAccount(values.id, values.customerUuid, values.points)
    }

}
