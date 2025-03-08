package org.cerdBlog.blogServer.service;

import jakarta.persistence.EntityNotFoundException;
import org.cerdBlog.blogServer.dto.PostDTO;
import org.cerdBlog.blogServer.entity.Post;
import org.cerdBlog.blogServer.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getLastPostById(){
        return postRepository.finTop
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            postRepository.save(post);
            return post;
        } else {
            throw new EntityNotFoundException("Post not found!");
        }
    }

    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setName(postDTO.getName());
        post.setContent(postDTO.getContent());
        post.setPostedBy(postDTO.getPostedBy());
        post.setImg(postDTO.getImg());
        post.setDate(postDTO.getDate());
        post.setLikeCount(postDTO.getLikeCount());
        post.setViewCount(postDTO.getViewCount());
        post.setTags(postDTO.getTags());
        return post;
    }
}
