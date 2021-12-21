package com.revature.project3.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reaction_id")
    private Long reactionId;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
    //private Long postId;

//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Long commentId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
    //private Long userId;

    private int reaction;

    public Long getReactionId() {
        return reactionId;
    }

    public void setReactionId(Long reactionId) {
        this.reactionId = reactionId;
    }

//    public Long getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Long postId) {
//        this.postId = postId;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }
}
