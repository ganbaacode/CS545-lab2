package com.example.lab1.service;

import com.example.lab1.entity.User;
import com.example.lab1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo UserRepository;

    public User addUser(User user){
        return UserRepository.save(user);
    }

    public List<User> findAll(){
        return UserRepository.findAll();
    }

}
