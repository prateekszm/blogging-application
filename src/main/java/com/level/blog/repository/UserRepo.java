package com.level.blog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.level.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	
	@Query(value = ":query", nativeQuery = true)
	List<User> findByCustomQuery(@Param("query") String query);
	
}
