package com.revature.project3.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reaction_id")
    private Long reactionId;

    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "reactions_post")
    private Long postId;

//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Long commentId;


//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "reactions_user")

    private Long userId;


    private int reaction;

   
}
