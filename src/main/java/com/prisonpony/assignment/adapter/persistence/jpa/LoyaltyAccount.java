package com.prisonpony.assignment.adapter.persistence.jpa;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "loyalty_account")
public class LoyaltyAccount {
    @Id
    @Column(nullable = false)
    public UUID id;

    @Column(nullable = false, name = "customer_uuid")
    public UUID customerUuid;

    @Column(nullable = false)
    public int points;

    public LoyaltyAccount() {
    }

    public LoyaltyAccount(final UUID id, final UUID customerUuid, final int points) {
        this.id = id;
        this.customerUuid = customerUuid;
        this.points = points;
    }
}
