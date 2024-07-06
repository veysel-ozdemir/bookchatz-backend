package com.internship.blog.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.blog.book.Book;
import com.internship.blog.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @GeneratedValue
    @Id
    @Column(name = "post_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;
    private String review;
}
