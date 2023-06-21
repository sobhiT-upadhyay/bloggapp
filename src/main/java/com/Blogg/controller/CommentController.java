package com.Blogg.controller;


import com.Blogg.payload.CommentDto;

import com.Blogg.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    //localhost:8080/api/posts/{postId}/comments
    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {


        CommentDto savedComment = commentService.createComment(postId, commentDto);

        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }


}
