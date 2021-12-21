package com.revature.project3.controllers;

import com.revature.project3.entities.Post;
import com.revature.project3.services.PostFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostFeedController {

    @Autowired
    private PostFeedService feedService;

    @PostMapping("/postfeed/addnew")
    public Post addPost(@RequestBody Post p){
        return feedService.addPost(p);
    }

    @GetMapping("/postfeed")
    public List<Post> getAllPosts(){
        return feedService.getAllPosts();
    }

    @GetMapping("/postfeed/{uID}")
    public List<Post> getPostsByOwner(@PathVariable("uID") long user_id){
        return  feedService.getAllPostsByOwner(user_id);
    }
}
