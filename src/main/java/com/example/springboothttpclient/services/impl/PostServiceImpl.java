package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Post;
import com.example.springboothttpclient.dao.PostDao;
import com.example.springboothttpclient.services.facade.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }


    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postDao.findById(id).orElse(null);
    }

    @Override
    public Post save(Post post) {
        return postDao.save(post);
    }

    @Override
    public Post update(Post post, Long id) {
        Post foundedPost = findById(id);
        if (foundedPost == null) return null;
        return postDao.save(post);
    }

    @Override
    public int delete(Long id) {
        Post foundedPost = findById(id);
        if (foundedPost == null) return -1;
        postDao.deleteById(id);
        return 1;
    }
}
