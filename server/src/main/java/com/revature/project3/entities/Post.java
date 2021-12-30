package com.revature.project3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // TODO, reach out to user team and figure out mapping:
    private Long userId;
    private String title;
    private String description;
    private String img;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime creationDate;
    private Long upmints;
    private Long downmints;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_comments")
    private List<Comment> commentList;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_reactions")
    private List<Reaction> reactionList;
    // private List<Tag> tagList;
}
