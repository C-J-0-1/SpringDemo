package com.practice.conferencethymeleaf.repositories;

import com.practice.conferencethymeleaf.models.Session;

import java.util.List;

public interface SessionCustomJpaRepository {
    List<Session> customGetSessions();
}
