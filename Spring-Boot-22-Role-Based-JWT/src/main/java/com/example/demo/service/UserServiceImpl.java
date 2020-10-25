package com.example.demo.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){ 
    	user.setRealPassword(user.getPassword());
        user.setPassword(passwordEncoder.encode( user .getPassword()));
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
