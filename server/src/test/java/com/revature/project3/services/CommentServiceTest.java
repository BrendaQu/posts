package com.revature.project3.services;

import com.revature.project3.entities.Comment;
import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    private Long postId;

    @BeforeEach
    void setUp() {
        Post post = new Post();
        post.setDescription("New Post");
        post.setCommentList(new ArrayList<>());
        Post post_db = postService.addPost(post);
        postId = post_db.getId();
        return;
    }

    @Test
    // Test adding a new comment to the database:
    void testAddComment() {
        Comment comment = new Comment();
        comment.setDescription("This is a new comment");
        comment.setDate(new Date());
        comment = commentService.addComment(comment, postId);
        Comment comment_db = commentService.findById(comment.getId());
        assertEquals("This is a new comment", comment_db.getDescription());
    }

    @Test
    // test getting comments for a specific post:
    void testGetCommentsForPost() {
        // assign 3 comments to a given post:
        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        comment1.setDescription("Comment");
        comment2.setDescription("Comment");
        comment3.setDescription("Comment");
        comment1.setDate(new Date());
        comment2.setDate(new Date());
        comment3.setDate(new Date());
        commentService.addComment(comment1, postId);
        commentService.addComment(comment2, postId);
        commentService.addComment(comment3, postId);
        // make sure all 3 comments were added:
        List<Comment> commentList = commentService.getCommentsForPost(postId);
        assertEquals(3, commentList.size());
    }

    @Test
    // test deleting comment
    void testDeleteComment() {
        Comment comment = new Comment();
        comment.setDescription("New description");
        comment.setDate(new Date());
        Comment comment_db = commentService.addComment(comment, postId);
        commentService.deleteComment(comment_db.getId());
        

    }

}
