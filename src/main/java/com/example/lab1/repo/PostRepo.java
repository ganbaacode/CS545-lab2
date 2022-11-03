package com.example.lab1.repo;

import com.example.lab1.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void delete(int id);

    public void update(int id,Post p);
}
