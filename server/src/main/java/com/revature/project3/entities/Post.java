package com.revature.project3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Post {
    private Long id;
    // TODO, reach out to user team and figure out mapping:
    private Long userId;
    private String title;
    private String description;
    private String img;

    private List<Comment> commentList;
    private List<Reaction> reactionList;
    // private List<Tag> tagList;
}
