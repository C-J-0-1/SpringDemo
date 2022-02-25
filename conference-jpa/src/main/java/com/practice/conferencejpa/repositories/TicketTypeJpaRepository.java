package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {

    //Using Query DSL
    List<TicketType> findByIncludesWorkshopTrue();
}
