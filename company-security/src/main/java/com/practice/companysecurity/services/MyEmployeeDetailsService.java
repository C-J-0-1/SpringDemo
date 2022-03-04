package com.practice.companysecurity.services;

import com.practice.companysecurity.models.Employee;
import com.practice.companysecurity.models.MyEmployeeDetails;
import com.practice.companysecurity.repositories.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeJpaRepository.findByFirstName(username);
        if(employee == null)
            throw new UsernameNotFoundException("Employee Not Found.");
        return new MyEmployeeDetails(employee);
    }
}
