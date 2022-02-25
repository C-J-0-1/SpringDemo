package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.Session;

import java.util.List;

public interface SessionCustomJpaRepository {
    List<Session> customGetSessions();
}
