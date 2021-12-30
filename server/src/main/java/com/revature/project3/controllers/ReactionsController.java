package com.revature.project3.controllers;

import com.revature.project3.entities.Reaction;
import com.revature.project3.services.ReactionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reactions")
public class ReactionsController {
    @Autowired
    private ReactionsServiceImpl reactionsService;

    @PostMapping("/{id}")
    public Reaction saveReaction(@RequestBody Reaction reaction, @PathVariable("id") Long postId){
        return reactionsService.addReaction(reaction, postId);
    }

    @GetMapping("/reactionId/{id}")
    public Reaction getReactionById(@PathVariable("id") Long reactionId){
        return reactionsService.getReactionByReactionId(reactionId);
    }

    @GetMapping("/postId/{id}")
    public List<Reaction> getReactionByPostId(@PathVariable("id") Long reactionId){
        return reactionsService.getReactionByPostId(reactionId);
    }

    @PutMapping("/update/{id}")
    public Reaction updateReaction(@PathVariable("id") Long id, @RequestBody Reaction updateReaction){
        return reactionsService.updateReaction(updateReaction, id);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteReaction(@PathVariable("id") Long reactionId){
        reactionsService.deleteReaction(reactionId);
        return "reaction deleted successfully";
    }
}
