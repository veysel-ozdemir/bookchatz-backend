package com.internship.blog.repository;

import com.internship.blog.dto.PostQueryDto;
import com.internship.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT new com.internship.blog.dto.PostQueryDto(p.book.title, p.book.authorName, p.book.bookType, p.book.photoUrl, p.review, p.id) " +
            "FROM Post p WHERE p.user.id = :userId")
    List<PostQueryDto> findPostsByUserId(@Param("userId") Integer userId);
}
