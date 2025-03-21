package com.cerdblog.springserver.repository;


import com.cerdblog.springserver.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findTopByOrderByIdDesc();
}
