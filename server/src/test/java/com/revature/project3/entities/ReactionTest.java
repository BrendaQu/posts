package com.revature.project3.entities;

import com.revature.project3.utils.ReactionsEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReactionTest {
    Reaction testReaction;

    @BeforeEach
    void startUp(){
        testReaction = new Reaction();
        testReaction.setReactionId(15L);
        testReaction.setPostId(20L);
        testReaction.setUserId(25L);
        testReaction.setReaction(ReactionsEnum.CRY);
    }
    @AfterEach
    void tearDown(){
        testReaction = null;
    }

    @Test
    public void testGetters(){
        assertSame(15L, testReaction.getReactionId());
        assertSame(20L,testReaction.getPostId());
        assertSame(25L, testReaction.getUserId());
        assertSame(ReactionsEnum.CRY, testReaction.getReaction());
    }

    @Test
    public void testToString(){
        System.out.println(testReaction.toString());
    }

    @Test
    public void testAllArgsConstructor(){
        Reaction newReaction = new Reaction(15L,20L,25L,ReactionsEnum.CRY);
        System.out.println(newReaction);
    }


}