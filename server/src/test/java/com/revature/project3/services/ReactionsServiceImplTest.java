package com.revature.project3.services;

import com.revature.project3.entities.Post;
import com.revature.project3.entities.Reaction;
import com.revature.project3.repositories.PostRepository;
import com.revature.project3.repositories.ReactionsRepository;
import com.revature.project3.utils.ReactionsEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class ReactionsServiceImplTest {

    Reaction testReaction;
    Reaction fullReaction;
    Post testPost;
    Optional<Post> optionalPost;
    List<Reaction> reactionList;

    @BeforeEach
    void setUp() {
        testReaction = new Reaction();
        testReaction.setReaction(ReactionsEnum.CRY);

        fullReaction = testReaction;
        fullReaction.setReactionId(10L);

        reactionList = new ArrayList<Reaction>();
        reactionList.add(testReaction);
        reactionList.add(fullReaction);

        testPost = new Post();
        testPost.setReactionList(reactionList);
        optionalPost = Optional.of(testPost);
    }

    @AfterEach
    void tearDown() {
        testReaction = null;
        fullReaction = null;
        testPost = null;
        optionalPost = Optional.empty();
        reactionList = null;
    }
    @Autowired
    private ReactionsServiceImpl reactionsService;

    @MockBean
    private ReactionsRepository repository;
    @MockBean
    private PostRepository postRepository;

    @Test
    public void testAddWhenReactionIsProvided_ThenReactionWithIdIsReturned(){
        Mockito.when(postRepository.findById(10L)).thenReturn(optionalPost);
        Mockito.when(postRepository.save(testPost)).thenReturn(testPost);
        Mockito.when(postRepository.getById(10L)).thenReturn(testPost);
        Mockito.when(repository.save(testReaction)).thenReturn(fullReaction);

        assertSame(fullReaction, reactionsService.addReaction(testReaction, 10L));
    }

    @Test
    public void testGetWhenReactionIdIsProvided_ThenReactionIsReturned(){
        Mockito.when(repository.findById(10L)).thenReturn(java.util.Optional.ofNullable(fullReaction));

        assertSame(fullReaction, reactionsService.getReactionByReactionId(10L));
    }

    @Test
    public void testUpdateWhenReactionAndIdIsProvided_ThenReactionIsReturned(){
        Mockito.when(repository.findById(10L)).thenReturn(java.util.Optional.ofNullable(fullReaction));
        Mockito.when(repository.save(fullReaction)).thenReturn((fullReaction));

        assertSame(fullReaction, reactionsService.updateReaction(testReaction, 10L));
    }

    @Test
    public void testDeleteWhenReactionIdIsProvided_ThenReturnString(){
        Mockito.doNothing().when(repository).deleteById(10L);

        assertSame("Entry Successfully Deleted", reactionsService.deleteReaction(10L));
    }

    @Test
    public void testGetReactionByPostIdWhenPostIdIsPassed_ThenReturnReactionList(){
        Mockito.when(postRepository.getById(10L)).thenReturn(testPost);

        assertSame(reactionList, reactionsService.getReactionByPostId(10L));
    }
}