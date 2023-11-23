package com.example.springboothttpclient.dao;

import com.example.springboothttpclient.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
