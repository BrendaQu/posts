package com.revature.project3.repositories;

import com.revature.project3.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostFeedRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.userId = ?1")
    public List<Post> findByUserID(long uid);
}
