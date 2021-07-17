package com.sunclock.book.springbootMVC.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Entity class and its repository should be located together! so @Repository annotation is not needed.
public interface PostsRepository extends JpaRepository<Posts, Long> { // <Entity class, PK type>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
        // method not provided by SpringDataJpa can be written like this!
        // Querydsl for larger projects when selecting data
    List<Posts> findAllDesc();
}
