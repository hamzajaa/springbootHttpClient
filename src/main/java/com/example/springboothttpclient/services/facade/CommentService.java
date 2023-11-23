package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.Address;
import com.example.springboothttpclient.beans.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    Comment findById(Long id);

    Comment save(Comment comment);

    Comment update(Comment comment, Long id);

    int delete(Long id);

}
