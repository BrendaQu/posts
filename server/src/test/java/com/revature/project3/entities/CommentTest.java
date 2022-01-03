package com.revature.project3.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CommentTest {

    Comment testComment;
    Date date;

    @BeforeEach
    void startUp(){
        date = new Date("Mon Jan 03 14:06:38 CST 2022");
        testComment = new Comment();
        testComment.setParentComment(10L);
        testComment.setAuthor("Shakespeare");
        testComment.setDate(date);
        testComment.setDescription("Romeo");
        testComment.setId(10L);
    }
    @AfterEach
    void tearDown(){
        testComment = null;
    }

    @Test
    public void testGettersForCommentEntity(){
        assertSame(10L,testComment.getParentComment());
        assertSame("Shakespeare", testComment.getAuthor());
        assertSame("Romeo", testComment.getDescription());
        assertSame(date, testComment.getDate());
        assertSame(10L, testComment.getId());
    }

    @Test
    public void testToString(){
        assertEquals("Comment(id=10, description=Romeo, date=Mon Jan 03 14:06:38 CST 2022, author=Shakespeare, parentComment=10)", testComment.toString());
    }

    @Test
    public void testAllArgsConstructor(){
        Comment newComment = new Comment(10L,"Romeo", date, "Shakespeare", 10L);

        assertEquals("Comment(id=10, description=Romeo, date=Mon Jan 03 14:06:38 CST 2022, author=Shakespeare, parentComment=10)", newComment.toString());
    }

}