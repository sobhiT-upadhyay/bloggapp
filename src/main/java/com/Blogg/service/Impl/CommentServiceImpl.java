package com.Blogg.service.Impl;

import com.Blogg.entity.Comment;
import com.Blogg.entity.Post;
import com.Blogg.execption.EntityNotFoundException;
import com.Blogg.payload.CommentDto;
import com.Blogg.repository.CommentRepository;
import com.Blogg.repository.PostRepository;
import com.Blogg.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById((long) postId).orElseThrow(
                () -> new EntityNotFoundException("No record found")
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

   Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

     CommentDto mapToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;
    }
}
