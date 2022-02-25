package com.practice.conferencethymeleaf.models;

import com.practice.conferencethymeleaf.repositories.TicketTypeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TicketTypeTest {
    @Autowired
    private TicketTypeJpaRepository jpaRepository;

    @Test
    public void testJpaTrue() throws Exception{
        List<TicketType> ticketTypes = jpaRepository.findByIncludesWorkshopTrue();
        assertTrue(ticketTypes.size() > 0);
    }

}
