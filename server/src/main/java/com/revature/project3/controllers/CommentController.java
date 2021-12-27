package com.revature.project3.controllers;

import com.revature.project3.entities.Comment;
import com.revature.project3.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{id}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable("id") Long postId) {
        System.out.println(comment.getDate());
        return commentService.addComment(comment, postId);
    }

    @GetMapping("/{id}")
    public List<Comment> getCommentsForPost(@PathVariable("id") Long postId) {
        return commentService.getCommentsForPost(postId);
    }

    @DeleteMapping("/{id}")
    public Comment deleteComment(@PathVariable("id") Long commentId) {
        return commentService.deleteComment(commentId);
    }

    @PostMapping("/reply")
    public Comment reply(@RequestParam("postId") Long postId, @RequestParam("parentId") Long parentId, @RequestBody Comment reply) {
        return commentService.reply(postId, parentId, reply);
    }

    @GetMapping("/reply/{id}")
    public List<Comment> getReplies(@PathVariable("id") Long commentId) {
        return commentService.getReplies(commentId);
    }

}
