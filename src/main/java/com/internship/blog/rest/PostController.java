package com.internship.blog.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(@Qualifier("post-service") PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    /*@GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String get() {
        return "Get Mapping Called";
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String post(@RequestBody String body) {
        return "Post Mapping Called | Request Body: " + body;
    }
//    http://localhost:8080/get-path-var/alex
    @GetMapping("/get-path-var/{var}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getPathVar(@PathVariable("var") String var) {
        return "The path variable is: " + var;
    }

//    http://localhost:8080/get-req-param?name=alex&age=45
    @GetMapping("/get-req-param")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getReqParam(@RequestParam("name") String name, @RequestParam("age") String age) {
        return "The request parameters are: " + name + " & " + age;
    }*/
}
