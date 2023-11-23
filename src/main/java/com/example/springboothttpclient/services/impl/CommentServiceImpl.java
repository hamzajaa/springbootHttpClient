package com.example.springboothttpclient.services.impl;

import com.example.springboothttpclient.beans.Comment;
import com.example.springboothttpclient.beans.Post;
import com.example.springboothttpclient.dao.CommentDao;
import com.example.springboothttpclient.services.facade.CommentService;
import com.example.springboothttpclient.services.facade.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;
    private PostService postService;

    public CommentServiceImpl(CommentDao commentDao, PostService postService) {
        this.commentDao = commentDao;
        this.postService = postService;
    }


    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentDao.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        if (comment == null) return null;
        Post post = postService.findById(Long.parseLong(comment.getPostId()));
        if (post == null) return null;
        return commentDao.save(comment);
    }

    @Override
    public Comment update(Comment comment, Long id) {
        Comment foundedComment = findById(id);
        if (foundedComment == null) return null;
        return commentDao.save(comment);
    }

    @Override
    public int delete(Long id) {
        Comment foundedComment = findById(id);
        if (foundedComment == null) return -1;
        commentDao.deleteById(id);
        return 1;
    }
}
