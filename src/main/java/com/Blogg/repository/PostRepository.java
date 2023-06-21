package com.Blogg.repository;

import com.Blogg.entity.Post;
import com.Blogg.payload.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
