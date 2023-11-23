package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.Post;
import com.example.springboothttpclient.dao.PostDao;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    Post findById(Long id);

    Post save(Post post);

    Post update(Post post, Long id);

    int delete(Long id);

}
