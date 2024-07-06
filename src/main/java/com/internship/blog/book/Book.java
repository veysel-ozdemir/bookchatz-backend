package com.internship.blog.book;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.blog.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue
    @Id
    @Column(name = "book_id")
    private Integer id;
    private String title;
    private String authorName;
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    @Column(name = "photo_url")
    private String photoUrl;
    @OneToMany(
            mappedBy = "book"
    )
    @JsonManagedReference
    private List<Post> posts;
}
