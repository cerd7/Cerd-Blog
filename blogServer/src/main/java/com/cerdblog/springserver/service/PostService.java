package com.cerdblog.springserver.service;


import com.cerdblog.springserver.dto.PostDTO;
import com.cerdblog.springserver.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost(PostDTO post);

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    Post getLastPostById();
}
