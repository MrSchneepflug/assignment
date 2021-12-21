package com.prisonpony.assignment.adapter.persistence.jpa

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface TicketRepository : JpaRepository<Ticket, UUID>
