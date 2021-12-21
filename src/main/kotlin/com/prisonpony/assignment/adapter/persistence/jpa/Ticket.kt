package com.prisonpony.assignment.adapter.persistence.jpa

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "tickets")
data class Ticket(
        @Id
        @Column(nullable = false)
        val id: UUID,

        @Column(nullable = false, name = "seat_id")
        val seatId: UUID,

        @Column(nullable = false)
        val reserved: Boolean
)
