package com.prisonpony.assignment.adapter.rest

import com.prisonpony.assignment.adapter.persistence.jpa.Ticket
import com.prisonpony.assignment.adapter.persistence.jpa.TicketRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tickets")
class TicketController(val ticketRepository: TicketRepository) {

    @GetMapping()
    fun getTickets(): ResponseEntity<List<Ticket>> {
        val tickets = ticketRepository.findAll()
        return ResponseEntity.ok(tickets)
    }

}
