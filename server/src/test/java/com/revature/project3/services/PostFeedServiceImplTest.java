package com.revature.project3.services;

import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostFeedRepository;
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
class PostFeedServiceImplTest {

    Post testPost;
    Post fullPost;
    List<Post> postList;

    @BeforeEach
    void setUp(){
        testPost = new Post();
        fullPost = new Post();
        fullPost.setId(10L);

        postList = new ArrayList<Post>();
        postList.add(testPost);
        postList.add(fullPost);
    }

    @AfterEach
    void tearDown(){
        testPost = null;
        fullPost = null;
        postList = null;
    }

    @Autowired
    private PostFeedServiceImpl postFeedService;

    @MockBean
    private PostFeedRepository postFeedRepository;

    @Test
    public void testAddPostWhenPostIsProvided_ThenReturnPostWithId(){
        Mockito.when(postFeedRepository.save(testPost)).thenReturn(fullPost);

        assertSame(fullPost, postFeedService.addPost(testPost));
    }

    @Test
    public void testGetAllPostsWhenNothingIsProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedRepository.findAll()).thenReturn(postList);

        assertSame(postList, postFeedService.getAllPosts());
    }

    @Test
    public void testGetPostsByOwnerWhenUserIdProvided_ThenReturnListOfPosts(){
        Mockito.when(postFeedRepository.findByUserID(10l)).thenReturn(postList);

        assertSame(postList, postFeedService.getAllPostsByOwner(10l));
    }

    @Test
    public void testGetPostsBeforeWhenDateIsProvided_ThenReturnListOfPosts(){
        LocalDateTime dateTime = LocalDateTime.now();
        Mockito.when(postFeedRepository.findByDateBefore(dateTime)).thenReturn(postList);

        assertSame(postList, postFeedService.getAllPostsBefore(dateTime));
    }

    @Test
    public void testGetPostsAfterWhenDateIsProvided_ThenReturnListOfPosts(){
        LocalDateTime dateTime = LocalDateTime.now();
        Mockito.when(postFeedRepository.findByDateAfter(dateTime)).thenReturn(postList);

        assertSame(postList, postFeedService.getAllPostsAfter(dateTime));
    }

    @Test
    public void testGetAllPostsContainingWhenStringIsProvided_ThenReturnListOfPosts(){
        String test = "Test";
        Mockito.when(postFeedRepository.findByContentContaining(test)).thenReturn(postList);

        assertSame(postList, postFeedService.getAllPostsContaining(test));
    }
}