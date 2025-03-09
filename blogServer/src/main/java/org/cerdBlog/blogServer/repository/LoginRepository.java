package org.cerdBlog.blogServer.repository;

import org.cerdBlog.blogServer.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    Optional<Login> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}