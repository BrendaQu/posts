package com.revature.project3.services;

import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostsServiceImplTest {

    Post testPost;
    Post fullPost;
    Optional<Post> postOptional;

    @BeforeEach
    void setUp(){
        testPost = new Post();
        fullPost = new Post();
        fullPost.setId(10L);

        postOptional = Optional.of(fullPost);
    }

    @AfterEach
    void tearDown(){
        testPost = null;
        fullPost = null;
        postOptional = Optional.empty();
    }

    @Autowired
    PostsServiceImpl postsService;

    @MockBean
    PostRepository postRepository;

    @Test
    public void testAddPostWhenPostIsProvided_ThenReturnPostWithId(){
        Mockito.when(postRepository.save(testPost)).thenReturn(fullPost);

        assertSame(fullPost, postsService.addPost(testPost));
    }

    @Test
    public void testGetPostByIdWhenIdIsProvided_ThenReturnOptionalPost(){
        Mockito.when(postRepository.findById(10L)).thenReturn(postOptional);

        assertSame(fullPost, postsService.getPostById(10L));
    }

    @Test
    public void testGetPostByIdWhenIdIsProvided_ThenReturnNull(){
        Mockito.when(postRepository.findById(10L)).thenReturn(Optional.empty());

        assertNull(postsService.getPostById(10L));
    }

    @Test
    public void testUpdatePostWhenPostIsProvided_ThenReturnUpdatedPost(){
        Mockito.when(postRepository.save(testPost)).thenReturn(fullPost);

        assertSame(fullPost, postsService.updatePost(testPost));
    }

}