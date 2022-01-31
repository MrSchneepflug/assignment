package com.prisonpony.assignment.adapter.persistence.jpa

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "loyalty_account")
data class LoyaltyAccount(
        @Id
        @Column(nullable = false)
        val id: UUID,

        @Column(nullable = false, name = "customer_uuid")
        val customerUuid: UUID,

        @Column(nullable = false)
        val points: Int
)
