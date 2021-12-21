package com.prisonpony.assignment.test.data

import com.prisonpony.assignment.adapter.persistence.jpa.Ticket

class Entities {

    static Ticket aTicket(Map params = [:]) {
        Map values = [
                id      : UUID.randomUUID(),
                seatId  : UUID.randomUUID(),
                reserved: false,
        ] << params

        new Ticket(values.id, values.seatId, values.reserved)
    }

}
