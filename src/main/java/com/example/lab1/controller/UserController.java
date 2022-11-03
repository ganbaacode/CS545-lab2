package com.example.lab1.controller;

import com.example.lab1.entity.User;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public User addUser(User user){
        return service.addUser(user);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return service.findAll();
    }

}
