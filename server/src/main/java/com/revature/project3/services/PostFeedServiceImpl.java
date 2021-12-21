package com.revature.project3.services;

import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostFeedServiceImpl implements PostFeedService{

    @Autowired
    private PostFeedRepository feedRepository;

    @Override
    public Post addPost(Post new_post) {
        return feedRepository.save(new_post);
    }

    @Override
    public List<Post> getAllPosts() {
        return feedRepository.findAll();
    }

    @Override
    public List<Post> getAllPostsByOwner(long user_id) {
        return feedRepository.findByUserID(user_id);
    }
}
