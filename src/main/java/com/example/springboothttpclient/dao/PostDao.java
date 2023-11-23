package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Long> {
}
