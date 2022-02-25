package com.practice.conferencethymeleaf.repositories;

import com.practice.conferencethymeleaf.models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotJpaRepository extends JpaRepository<TimeSlot, Long> {

    //Using Query DSL
    List<TimeSlot> findByTimeSlotDateAfter(LocalDate localDate);
}
