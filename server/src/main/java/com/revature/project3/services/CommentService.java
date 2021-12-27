package com.revature.project3.services;

import com.revature.project3.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public Comment addComment(Comment comment, Long postId);
    public Comment findById(Long id);
    public List<Comment> getCommentsForPost(Long postId);
    public void deleteComment(Long id);
    public Comment reply(Long postId, Long parentId, Comment child);
    public List<Comment> getReplies(Long commentId);
}
