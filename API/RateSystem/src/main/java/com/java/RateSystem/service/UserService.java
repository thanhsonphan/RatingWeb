package com.java.RateSystem.service;

import com.java.RateSystem.models.User;
import com.java.RateSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String password, String email, String role){
        if(username != null && password != null){
            return null;
        }else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(role);
            return userRepository.save(user);
        }
    }

    public User authenticate(String username, String password){
        return userRepository.findByPassword(username,password).orElse(null);
    }
}
