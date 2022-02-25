package com.practice.conferencesecurity.repositories;

import com.practice.conferencesecurity.models.Session;

import java.util.List;

public interface SessionCustomJpaRepository {
    List<Session> customGetSessions();
}
