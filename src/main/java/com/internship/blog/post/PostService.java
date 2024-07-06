package com.internship.blog.post;

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

    public String deletePostById(Integer id) {
        postRepository.deleteById(id);
        return "Post with id " + id + " was deleted";
    }
}
