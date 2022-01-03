package com.revature.project3.services;

import com.revature.project3.entities.Post;
import com.revature.project3.entities.Reaction;
import com.revature.project3.repositories.PostRepository;
import com.revature.project3.repositories.ReactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionsServiceImpl implements ReactionsService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReactionsRepository repository;

    @Override
    public Reaction addReaction(Reaction reaction, Long postId) {
        Post post_db = postRepository.findById(postId).get();
        List<Reaction> reactions_db = post_db.getReactionList();
        reactions_db.add(reaction);
        post_db.setReactionList(reactions_db);
        postRepository.save(post_db);
        //now get reaction from the db:
        post_db = postRepository.getById(postId);
        Reaction reaction_db = post_db.getReactionList().get(post_db.getReactionList().size()-1);
        return reaction_db;
        //return repository.save(reaction);
    }

    @Override
    public Reaction getReactionByReactionId(Long reactionId) {
        return repository.findById(reactionId).get();
    }

    @Override
    public List<Reaction> getReactionByPostId(Long postId) {
        return postRepository.getById(postId).getReactionList();
    }

    @Override
    public Reaction updateReaction(Reaction reaction, Long reactionId) {
        Reaction updateReaction = repository.findById(reactionId).get();
        updateReaction.setReaction(reaction.getReaction());
        return repository.save(updateReaction);
    }

    @Override
    public String deleteReaction(Long reactionId) {
        repository.deleteById(reactionId);
        return ("Entry Successfully Deleted");
    }
}
