package com.Blogg.controller;

import com.Blogg.entity.Post;
import com.Blogg.payload.PostDto;
import com.Blogg.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
//https://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        PostDto savedPostDto = postService.createPost(postDto);


        return new ResponseEntity<>(savedPostDto, HttpStatus.CREATED);
    }
    //localhost:8080/api/posts?pageNo=0&pageSize=5
    //pagination
    //sorting
    //localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=id&sortDir=asc
    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }
}
