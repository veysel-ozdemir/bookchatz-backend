package com.internship.blog.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.internship.blog.post.Post;
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
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Integer id;
    private String fullname;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(name = "photo_url")
    private String photoUrl;
    @OneToMany(
            mappedBy = "user"
    )
    private List<Post> posts;
}
