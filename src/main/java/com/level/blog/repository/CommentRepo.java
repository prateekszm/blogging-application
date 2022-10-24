package com.level.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.level.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
