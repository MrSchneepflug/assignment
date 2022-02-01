package com.prisonpony.assignment.adapter.rest

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount
import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccountRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class LoyaltyAccountController(val loyaltyAccountRepository: LoyaltyAccountRepository) {

    @GetMapping()
    fun getAccounts(): ResponseEntity<List<LoyaltyAccount>> {
        val customerAccounts = loyaltyAccountRepository.findAll()
        return ResponseEntity.ok(customerAccounts)
    }

}
