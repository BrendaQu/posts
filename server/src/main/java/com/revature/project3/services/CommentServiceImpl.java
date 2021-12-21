package com.revature.project3.services;

import com.revature.project3.entities.Comment;
import com.revature.project3.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    PostRepository repository;

    @Override
    public Comment addComment(Comment comment, Long postId) {
        return new Comment();
    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public List<Comment> getCommentsForPost(Long postId) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {

    }
}
