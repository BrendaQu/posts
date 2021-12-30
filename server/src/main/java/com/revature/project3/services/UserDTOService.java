package com.revature.project3.services;

import com.revature.project3.dto.UserPostResponse;
import com.revature.project3.repositories.PostFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserDTOService {
    public UserPostResponse getPostsWithUser(Long userId);
}
