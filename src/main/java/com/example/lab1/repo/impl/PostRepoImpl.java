package com.example.lab1.repo.impl;

import com.example.lab1.entity.Post;
import com.example.lab1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {


    private static List<Post> posts;
    private static int postId = 1001;

   static {
       posts = new ArrayList<>();

       Post p1=new Post(998,"What is Lorem Ipsum?",
               "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
               "Bruce Willis");
       Post p2 = new Post(999,"Why do we use it?",
               "It is a long established fact that a reader will be " +
                       "distracted by the readable content of a page when looking at its layout.",
               "Joseph Gordon");
       Post p3=new Post (1000,"Where can I get some?",
               "There are many variations of passages of Lorem Ipsum available, " +
                       "but the majority have suffered alteration in some form",
               "Robert Deniro");
       posts.add(p1);
       posts.add(p2);
       posts.add(p3);
   }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return posts
                .stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post p) {
       p.setId(postId);
       postId++;
       posts.add(p);
    }

    @Override
    public void delete(int id) {

       Post myPost = posts
                .stream()
                .filter(p->p.getId()==id)
                .findFirst().get();
        posts.remove(myPost);
    }

    @Override
    public void update(int id,Post po) {
        Post myPost = getById(id);
        myPost.setTitle(po.getTitle());
        myPost.setContent(po.getContent());
        myPost.setAuthor(po.getAuthor());

    }


}
