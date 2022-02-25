package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {

    //Using Query DSL
    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
    List<Speaker> findBySpeakerPhotoIsNull();
    List<Speaker> findByCompanyIn(List<String> companies);
    List<Speaker> findByCompanyIgnoreCase(String Company);
    List<Speaker> findByLastNameOrderByFirstNameAsc(String lastName);
    Speaker findFirstByFirstName(String firstName);
}
