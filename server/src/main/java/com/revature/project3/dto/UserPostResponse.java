package com.revature.project3.dto;

import com.revature.project3.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostResponse {
    User user;
    List<Post> postList;
}
