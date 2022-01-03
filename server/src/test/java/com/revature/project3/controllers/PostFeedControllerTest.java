package com.revature.project3.controllers;

import com.revature.project3.entities.Post;
import com.revature.project3.services.PostFeedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostFeedControllerTest {
    @Autowired
    PostFeedController postFeedController;
    @MockBean
    PostFeedService postFeedService;

    Post testPost;
    Post fullPost;
    List<Post> postList;
    LocalDateTime dateTime;

    @BeforeEach
    void startUp(){
        testPost = new Post();
        fullPost = new Post();
        fullPost.setId(10L);

        postList = new ArrayList<>();
        postList.add(testPost);
        postList.add(fullPost);

        dateTime = LocalDateTime.now();
    }
    @AfterEach
    void tearDown(){
        testPost = null;
        fullPost = null;
        postList = null;
        dateTime = null;
    }

    @Test
    public void testAddPostWhenPostIsProvided_ThenReturnPostWithId(){
        Mockito.when(postFeedService.addPost(testPost)).thenReturn(fullPost);

        assertSame(fullPost,postFeedController.addPost(testPost));
    }

    @Test
    public void testGetAllPosts_ThenReturnListOfPosts(){
        Mockito.when(postFeedService.getAllPosts()).thenReturn(postList);

        assertSame(postList, postFeedController.getAllPosts());
    }

    @Test
    public void testGetPostsByOwnerWhenUserIdIsProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedService.getAllPostsByOwner(10L)).thenReturn(postList);

        assertSame(postList, postFeedController.getPostsByOwner(10L));
    }

    @Test
    public void testGetPostsByContentWhenStringIsProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedService.getAllPostsContaining("Romeo")).thenReturn(postList);

        assertSame(postList, postFeedController.getPostsByContent("Romeo"));
    }

    @Test
    public void testGetPostsByDateBeforeWhenDateIsProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedService.getAllPostsBefore(dateTime)).thenReturn(postList);

        assertSame(postList, postFeedController.getPostsByDateBefore(dateTime));
    }

    @Test
    public void testGetPostsByDateAfterWhenDateIsProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedService.getAllPostsAfter(dateTime)).thenReturn(postList);

        assertSame(postList, postFeedController.getPostsByDateAfter(dateTime));
    }

}