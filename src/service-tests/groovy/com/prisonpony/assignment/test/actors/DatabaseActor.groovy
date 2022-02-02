package com.prisonpony.assignment.test.actors

import com.prisonpony.assignment.adapter.persistence.jpa.LoyaltyAccount
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class DatabaseActor {
    private final JdbcTemplate jdbcTemplate

    DatabaseActor(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate
    }

    List fetchAllRows(String tableName) {
        jdbcTemplate.queryForList("select * from ${tableName}")
    }

    void deleteAllEntries(String tableName) {
        jdbcTemplate.execute("delete from ${tableName}")
    }

    void withAccounts(List<LoyaltyAccount> accounts) {
        accounts.forEach({
            jdbcTemplate.execute("insert into loyalty_account values('${it.id}', '${it.customerUuid}', '${it.points}')")
        })
    }
}
