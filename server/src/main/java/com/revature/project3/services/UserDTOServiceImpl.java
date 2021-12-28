package com.revature.project3.services;

import com.revature.project3.dto.User;
import com.revature.project3.dto.UserPostResponse;
import com.revature.project3.entities.Post;
import com.revature.project3.repositories.PostFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserDTOServiceImpl implements UserDTOService{
    @Autowired
    private PostFeedRepository postFeedRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public UserPostResponse getPostsWithUser(Long userId) {
        // get posts for this user:
        List<Post> postList = postFeedRepository.findByUserID(userId);

        // get the user (TODO get the actual url)
        User user = restTemplate
                .getForObject("http://localhost:10001/user/id/" + userId,
                        User.class);

        // create the dto:
        UserPostResponse response = new UserPostResponse();
        response.setUser(user);
        response.setPostList(postList);
        return response;

    }
}
