package com.Blogg.service;

import com.Blogg.payload.CommentDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Blogg")
public interface CommentService {
    public CommentDto createComment(long postId, CommentDto commentDto);
}
