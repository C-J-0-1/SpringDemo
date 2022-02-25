package com.practice.conference.repositories;

import com.practice.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    //List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
}
