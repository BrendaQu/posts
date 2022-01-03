package com.revature.project3.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class PostTest {
    Post testPost;
    LocalDateTime dateTime;

    @BeforeEach
    void startUp(){
        dateTime = LocalDateTime.now();
        testPost = new Post();
        testPost.setId(10L);
        testPost.setUserId(15L);
        testPost.setTitle("TestPost");
        testPost.setDescription("TestPostDesc");
        testPost.setImg("Img");
        testPost.setCreationDate(dateTime);
        testPost.setUpmints(20L);
        testPost.setDownmints(30L);
    }
    @AfterEach
    void tearDown(){
        testPost = null;
    }

    @Test
    public void testGetters(){
        assertSame(10L,testPost.getId());
        assertSame(15L, testPost.getUserId());
        assertSame("TestPost", testPost.getTitle());
        assertSame("TestPostDesc", testPost.getDescription());
        assertSame("Img", testPost.getImg());
        assertSame(dateTime, testPost.getCreationDate());
        assertSame(20L, testPost.getUpmints());
        assertSame(30L, testPost.getDownmints());
    }

    @Test
    public void testToString(){
        System.out.println(testPost);
    }

    @Test
    public void testAllArgsConstructor(){
        Post newPost = new Post(10L,
                15L,
                "Title",
                "Desc",
                "Img",
                dateTime,
                20L,
                30L,
                null,
                null);

        System.out.println(newPost);
    }
}