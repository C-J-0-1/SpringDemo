package com.practice.conferencethymeleaf.controllers;

import com.practice.conferencethymeleaf.models.Session;
import com.practice.conferencethymeleaf.repositories.SessionJpaRepository;
import com.practice.conferencethymeleaf.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJpaRepository jpaRepository;

    @GetMapping
    public List<Session> list(@RequestParam(required = false) String name) {
        if(name != null) {
            return repository.getSessionsThatHaveName(name);
        } else {
            return repository.list();
        }
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return repository.find(id);
    }

    @GetMapping
    @RequestMapping("/countSessions/{sessionLength}")
    public Integer get(@PathVariable Integer sessionLength){
        return jpaRepository.countBySessionLength(sessionLength);
    }

    @GetMapping
    @RequestMapping("/pageNames/{name}")
    public Page<Session> get(@PathVariable String name){
        return jpaRepository.getSessionsWithName(name, PageRequest.of(1, 5, Sort.by(Sort.Direction.ASC, "sessionLength")));
    }

    @PostMapping
    public Session create(@RequestBody Session session){
        return repository.create(session);
    }

    @DeleteMapping
    //@RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.delete(id);
    }

    @PutMapping
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = repository.find(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return repository.update(session);
    }

}
