package com.internship.blog.service;

import com.internship.blog.dto.PostDto;
import com.internship.blog.dto.PostEditDto;
import com.internship.blog.model.Post;
import com.internship.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public Post createPost(PostDto postDto) {
        Post post = postMapper.toPost(postDto);
        postRepository.save(post);
        return post; // todo: change the return data later (ResponseDto)
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(PostEditDto postEditDto) {
        Post presentPost = postRepository.findById(postEditDto.postId()).orElse(null);
        Post updatedPost = postMapper.toUpdatedPost(postEditDto, presentPost);
        postRepository.save(updatedPost);
        return updatedPost; // todo: change the return data later (ResponseDto)
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
