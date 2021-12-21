package com.revature.project3.services;

import com.netflix.discovery.converters.Auto;
import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository repository;

    @Override
    public Post addPost(Post post) {
        return repository.save(post);
    }
}
