package com.revature.project3.controllers;

import com.revature.project3.entities.Reaction;
import com.revature.project3.services.ReactionsServiceImpl;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReactionsControllerTest {
    @Autowired
    ReactionsController controller;
    @MockBean
    ReactionsServiceImpl service;

    Reaction testReaction;
    Reaction fullReaction;
    List<Reaction> reactionList;

    @BeforeEach
    void setUp() {
        testReaction = new Reaction();
        fullReaction = new Reaction();
        fullReaction.setReactionId(10L);

        reactionList = new ArrayList<>();

        reactionList.add(testReaction);
        reactionList.add(fullReaction);
    }

    @AfterEach
    void tearDown() {
        testReaction =null;
        fullReaction = null;
        reactionList = null;
    }

    @Test
    public void testSaveReactionWhenReactionAndPostIdIsProvided_ThenReturnReactionWithId(){
        Mockito.when(service.addReaction(testReaction, 15L)).thenReturn(fullReaction);

        assertSame(fullReaction, controller.saveReaction(testReaction, 15L));
    }

    @Test
    public void testGetReactionByIdWhenIdIsProvided_ThenReturnReaction(){
        Mockito.when(service.getReactionByReactionId(10L)).thenReturn(fullReaction);

        assertSame(fullReaction, controller.getReactionById(10L));
    }

    @Test
    public void testGetReactionByPostIdWhenPostIdIsProvided_ThenReturnListOfReactions(){
        Mockito.when(service.getReactionByPostId(15L)).thenReturn(reactionList);

        assertSame(reactionList, controller.getReactionByPostId(15L));
    }

    @Test
    public void testUpdateReactionWhenIdAndReactionIsProvided_ThenReturnReaction(){
        Mockito.when(service.updateReaction(testReaction, 10L)).thenReturn(fullReaction);

        assertSame(fullReaction, controller.updateReaction(10L, testReaction));
    }

    @Test
    public void testDeleteReactionWHenIdIsProvided_ThenReturnString(){
        assertEquals("reaction deleted successfully", controller.deleteReaction(10L));
    }
}