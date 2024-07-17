package com.internship.blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.internship.blog.enums.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
            mappedBy = "book",
            fetch = FetchType.EAGER
    )
    private List<Post> posts;
}
