package com.practice.conferencesecurity.repositories;

import com.practice.conferencesecurity.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long>, SessionCustomJpaRepository {

    // Using Query DSL.
    List<Session> findBySessionNameContains(String name);
    List<Session> findBySessionLengthNot(Integer sessionLength);
    List<Session> findBySessionNameNotLike(String name);
    List<Session> findBySessionNameStartingWith(String start);
    List<Session> findBySessionLengthLessThan(Integer sessionLength);
    Integer countBySessionLength(Integer sessionLength);

    //For Paging
    @Query("select s.sessionName from Session s where s.sessionName like :name%")
    Page<Session> getSessionsWithName(@Param("name") String name, Pageable pageable);
}
