package com.example.lab1.service.impl;

import com.example.lab1.entity.Post;
import com.example.lab1.entity.dto.PostDto;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    public List<PostDto> getAllPostAuthor(){
        return postRepo.findAll()
                .stream()
                .map(p->convertToDto(p))
                .collect(Collectors.toList());

    }

    private PostDto convertToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setAuthor(post.getAuthor());
        return postDto;
    }


    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getById(int id) {
        return postRepo.getById(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id, Post p) {
        postRepo.update(id,p);
    }
}
