package com.practice.companysecurity.models;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@AllArgsConstructor
public class MyEmployeeDetails implements UserDetails {
    private Employee employee;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null;
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + employee.getRole()));
    }

    @Override
    public String getPassword() {
        return employee.getContact();
    }

    @Override
    public String getUsername() {
        return employee.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
