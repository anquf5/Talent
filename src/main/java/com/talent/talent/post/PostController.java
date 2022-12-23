package com.talent.talent.post;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping(path = "{postId}")
    public Post getPost(@PathParam("postId") Long postId){
        return postService.getPost(postId);
    }
}
