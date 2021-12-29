package com.revature.project3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Comment implements Comparable<Comment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    // data when this comment was posted:
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    // the user who created this comment:
    private String author;

    // the id of the comment which this comment is a reply to
    // this value will be null if it is it a top-level comment
    // (no parent)
    private Long parentComment;


    @Override
    public int compareTo(Comment other) {
        return other.getDate().compareTo(this.date);
    }
}
