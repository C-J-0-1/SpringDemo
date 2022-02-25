package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    @Query("select distinct(u.role) from User u")
    List<String> getRoles();
}
