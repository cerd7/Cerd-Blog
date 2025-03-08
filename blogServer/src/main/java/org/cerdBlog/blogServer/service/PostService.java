package org.cerdBlog.blogServer.service;


import org.cerdBlog.blogServer.dto.PostDTO;
import org.cerdBlog.blogServer.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(PostDTO post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    Post getLastPostById();
}
