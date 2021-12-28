package com.revature.project3.controllers;

import com.revature.project3.dto.UserPostResponse;
import com.revature.project3.services.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDTOService userDTOService;

    @GetMapping("/posts/dto/{id}")
    UserPostResponse getPostsWithUser(@PathVariable("id") Long userId) {
        return userDTOService.getPostsWithUser(userId);
    }
}
