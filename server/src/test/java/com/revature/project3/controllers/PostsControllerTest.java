package com.revature.project3.controllers;

import com.revature.project3.entities.Post;
import com.revature.project3.services.PostsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Stubber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostsControllerTest {

    @Autowired
    PostsController postsController;
    @MockBean
    PostsService service;

    Post testPost;
    Post fullPost;
    @BeforeEach
    void setUp() {
        testPost = new Post();
        fullPost = new Post();
        fullPost.setId(10L);
    }
    @AfterEach
    void tearDown() {
        testPost = null;
        fullPost = null;
    }

    @Test
    public void testSavePostWhenPostIsProvided_ThenReturnPostWithId(){
        Mockito.when(service.addPost(testPost)).thenReturn(fullPost);

        assertSame(fullPost, postsController.savePost(testPost));
    }

    @Test
    public void testGetPostByIdWhenIdIsProvided_ThenReturnPost(){
        Mockito.when(service.getPostById(10L)).thenReturn(fullPost);

        assertSame(fullPost, postsController.getPostById(10L));
    }

    @Test
    public void testDeletePostWhenIdIsProvided_ThenReturnString(){

        assertEquals("post deleted successfully", postsController.deletePost(10L));
    }

    @Test
    public void testUpdatePostWhenPostIsProvided_ThenReturnPost(){
        Mockito.when(service.updatePost(testPost)).thenReturn(fullPost);

        assertEquals(fullPost, postsController.updatePost(testPost));
    }

}