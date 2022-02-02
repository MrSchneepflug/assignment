package com.prisonpony.assignment.adapter.rest;

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount;
import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccountRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class LoyaltyAccountController {
    private final LoyaltyAccountRepository loyaltyAccountRepository;

    public LoyaltyAccountController(final LoyaltyAccountRepository loyaltyAccountRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
    }

    @GetMapping()
    public ResponseEntity<List<LoyaltyAccount>> getAccounts() {
        List<LoyaltyAccount> customerAccounts = loyaltyAccountRepository.findAll();
        return ResponseEntity.ok(customerAccounts);
    }
}
