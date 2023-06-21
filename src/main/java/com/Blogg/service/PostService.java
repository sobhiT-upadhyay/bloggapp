package com.Blogg.service;

import com.Blogg.entity.Post;
import com.Blogg.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto );


    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
