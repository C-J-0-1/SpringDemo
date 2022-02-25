package com.practice.conferencejpa.models;

import com.practice.conferencejpa.repositories.TimeSlotJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TimeSlotTest {
    @Autowired
    private TimeSlotJpaRepository jpaRepository;

    @Test
    public void testJpaDateAfter() throws Exception{
        List<TimeSlot> timeSlots = jpaRepository.findByTimeSlotDateAfter(LocalDate.parse("2020-04-09"));
        assertTrue(timeSlots.size() == 5);
    }
}
