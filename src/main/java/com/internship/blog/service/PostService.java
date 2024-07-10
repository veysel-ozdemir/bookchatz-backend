package com.internship.blog.service;

import com.internship.blog.dto.PostDto;
import com.internship.blog.dto.PostEditDto;
import com.internship.blog.model.Post;
import com.internship.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public ResponseEntity<Object> createPost(PostDto postDto) {
        // map the entity to Post
        Post post = postMapper.toPost(postDto);
        // save the entity
        postRepository.save(post);
        // return the mapped entity
        return ResponseEntity.ok(postMapper.toPostResponseDto(post));
    }

    public ResponseEntity<Object> getPosts() {
        return ResponseEntity.ok(postRepository.findAll().stream().map(postMapper::toPostResponseDto));
    }

    public ResponseEntity<Object> updatePost(PostEditDto postEditDto) {
        // get the present
        Post presentPost = postRepository.findById(postEditDto.postId()).orElse(null);
        // perform the changes
        Post updatedPost = postMapper.toUpdatedPost(postEditDto, presentPost);
        // save the entity
        postRepository.save(updatedPost);
        // return the mapped entity
        return ResponseEntity.ok(postMapper.toPostResponseDto(updatedPost));
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public String deletePostById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return "Post not found with id: " + id;
        }
        postRepository.deleteById(id);
        return "Post with id " + id + " was deleted";
    }
}
