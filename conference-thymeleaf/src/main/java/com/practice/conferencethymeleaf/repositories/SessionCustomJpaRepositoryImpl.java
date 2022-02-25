package com.practice.conferencethymeleaf.repositories;

import com.practice.conferencethymeleaf.models.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SessionCustomJpaRepositoryImpl implements SessionCustomJpaRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Session> customGetSessions() {
        return entityManager.createQuery("select s from Session s").getResultList();
    }
}
