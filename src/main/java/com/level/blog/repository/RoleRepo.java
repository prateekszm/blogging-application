package com.level.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.level.blog.entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}