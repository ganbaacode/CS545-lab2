package com.example.lab1.controller;

import com.example.lab1.entity.User;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

}
