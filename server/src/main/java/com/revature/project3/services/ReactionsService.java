package com.revature.project3.services;

import com.revature.project3.entities.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactionsService {
    Reaction addReaction(Reaction reaction, Long postId);
    Reaction getReactionByReactionId(Long reactionId);
    List<Reaction> getReactionByPostId(Long postId);
    Reaction updateReaction(Reaction reaction, Long reactionId);
    String deleteReaction(Long reactionId);
}
