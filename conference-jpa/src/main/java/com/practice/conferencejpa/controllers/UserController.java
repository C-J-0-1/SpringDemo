package com.practice.conferencejpa.controllers;

import com.practice.conferencejpa.models.User;
import com.practice.conferencejpa.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserJpaRepository repository;

    @GetMapping
    public List<User> list() {
        return repository.findAll();
    }
}