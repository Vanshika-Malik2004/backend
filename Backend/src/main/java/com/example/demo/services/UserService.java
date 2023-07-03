package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import java.util.*;
@Service
public class UserService {
    @Autowired
   private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    public User createUser(User user){
   
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User getUserById(long id){
 
        return userRepository.findByUserId(id).get();
    }

	public User updateUser(Long id, User user) {
		if(userRepository.findByUserId(id).isEmpty())return null;
		user.setUserId(id);
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
    

}
