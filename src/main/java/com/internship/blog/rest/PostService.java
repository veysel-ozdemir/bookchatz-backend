package com.internship.blog.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("post-service")
public class PostService {
    private final RestTemplate restTemplate;

    public PostService(@Qualifier("rest-template") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> getPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        return Arrays.asList(posts);
    }
}
