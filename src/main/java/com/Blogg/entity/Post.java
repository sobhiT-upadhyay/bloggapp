package com.Blogg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String content;
        private String description;
        private String title;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
        private List<Comment> comments = new ArrayList<>();

        }
