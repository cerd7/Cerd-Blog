package org.cerdBlog.blogServer.repository;


import org.cerdBlog.blogServer.dto.PostDTO;
import org.cerdBlog.blogServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findTopByOrderByIdDesc();
}
