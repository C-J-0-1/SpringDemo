package com.practice.conferencethymeleaf.repositories;

import com.practice.conferencethymeleaf.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {

    //Using Query DSL
    List<TicketType> findByIncludesWorkshopTrue();
}
