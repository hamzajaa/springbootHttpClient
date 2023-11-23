package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.Address;
import com.example.springboothttpclient.beans.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
