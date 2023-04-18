package com.ust.EmployeeSecurityJwt.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.EmployeeSecurityJwt.model.User;
import com.ust.EmployeeSecurityJwt.repository.UserRepo;
@Service

public class UserServices implements UserDetailsService{
	@Autowired
	private UserRepo repo;

	public User auth(User user) {
		
		
		return repo.save(user);
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }

}
