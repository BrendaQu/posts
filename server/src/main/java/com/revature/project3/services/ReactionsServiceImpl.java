package com.revature.project3.services;

import com.revature.project3.entities.Reaction;
import com.revature.project3.repositories.ReactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionsServiceImpl implements ReactionsService {

    @Autowired
    private ReactionsRepository repository;

    @Override
    public Reaction addReaction(Reaction reaction) {
        return repository.save(reaction);
    }

    @Override
    public Reaction getReactionByReactionId(Long reactionId) {
        return repository.findById(reactionId).get();
    }

    @Override
    public Reaction getReactionByPostId(Long postId) {
        return repository.findByPostId(postId);
    }

    @Override
    public Reaction updateReaction(Reaction reaction, Long reactionId) {
        Reaction reaction1 = repository.findById(reactionId).get();
        reaction1.setReaction(reaction.getReaction());
        return repository.save(reaction);
    }

    @Override
    public void deleteReaction(Long reactionId) {
        repository.deleteById(reactionId);
    }
}
