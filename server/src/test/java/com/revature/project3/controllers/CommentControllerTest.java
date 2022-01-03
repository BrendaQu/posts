package com.revature.project3.controllers;

import com.revature.project3.entities.Comment;
import com.revature.project3.services.CommentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    CommentController controller;
    @MockBean
    CommentService service;

    Comment testComment;
    Comment fullComment;
    List<Comment> commentList;

    @BeforeEach
    void startUp(){
        testComment = new Comment();
        fullComment = new Comment();
        fullComment.setId(15L);

        commentList = new ArrayList<Comment>();
        commentList.add(testComment);
        commentList.add(fullComment);
    }
    @AfterEach
    void tearDown(){
        testComment = null;
        fullComment = null;
        commentList = null;
    }

    @Test
    public void testAddCommentWhenCommentIsProvided_ThenReturnCommentWithId(){
        Mockito.when(service.addComment(testComment, 10L)).thenReturn(fullComment);

        assertSame(fullComment, controller.addComment(testComment, 10L));
    }

    @Test
    public void testGetCommentsForPostWhenPostIdIsProvided_ThenReturnListOfComments(){
        Mockito.when(service.getCommentsForPost(10L)).thenReturn(commentList);

        assertSame(commentList,controller.getCommentsForPost(10L));
    }

    @Test
    public void testDeleteCommentWhenCommentIdIsProvided_ThenReturnComment(){
        Mockito.when(service.deleteComment(10L)).thenReturn(fullComment);

        assertSame(fullComment, controller.deleteComment(10L));
    }

    @Test
    public void testReplyToPostWhenPostIdAndCommentIsProvided_ThenReturnComment(){
        Mockito.when(service.reply(10L, testComment)).thenReturn(fullComment);

        assertSame(fullComment,controller.reply(10L,testComment));
    }

    @Test
    public void testGetRepliesWhenCommentIdIsProvided_ThenReturnListOfComments(){
        Mockito.when(service.getReplies(10L)).thenReturn(commentList);

        assertSame(commentList, controller.getReplies(10L));
    }

}