package com.prisonpony.assignment.test.actors

import com.prisonpony.assignment.adapter.persistence.jpa.Ticket
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

    void withTickets(List<Ticket> tickets) {
        tickets.forEach({
            jdbcTemplate.execute("insert into tickets values('${it.id}', '${it.seatId}', '${it.reserved}')")
        })
    }
}
