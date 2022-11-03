package com.example.lab1.controller;


import com.example.lab1.entity.Post;
import com.example.lab1.entity.dto.PostDto;
import com.example.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = {"http://localhost:8080"})
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/post-authors")
    public List<PostDto> getAllAuthor(){
        return postService.getAllPostAuthor();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAll(){
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getById(@PathVariable int id){
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Post p){
        postService.save(p);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void update(@PathVariable int id,@RequestBody Post po){
        postService.update(id,po);
    }
}
