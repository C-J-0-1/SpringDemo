package com.practice.conferencesecurity.repositories;

import com.practice.conferencesecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);

    @Query("select distinct(u.role) from User u")
    List<String> getRoles();
}
