package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    //load user from database
    User user = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User not found"));
    return user;
  }
}
