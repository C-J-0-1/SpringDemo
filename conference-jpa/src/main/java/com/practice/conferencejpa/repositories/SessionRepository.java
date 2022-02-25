package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {

    @Autowired
    private SessionJpaRepository jpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
        return jpaRepository.saveAndFlush(session);
    }

    public Session update(Session session) {
        return jpaRepository.saveAndFlush(session);
    }

    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    public Session find(Long id) {
        return jpaRepository.getById(id);
    }

    public List<Session> list() {
        return jpaRepository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
        return jpaRepository.findBySessionNameContains(name);
    }
}
