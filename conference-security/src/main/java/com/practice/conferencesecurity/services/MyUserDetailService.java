package com.practice.conferencesecurity.services;

import com.practice.conferencesecurity.models.MyUserDetail;
import com.practice.conferencesecurity.models.User;
import com.practice.conferencesecurity.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User Not Found.");
        return new MyUserDetail(user);
    }

}
