package com.example.springboothttpclient.services.facade;

import com.example.springboothttpclient.beans.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);

    User save(User user);

    User update(User user, Long id);

    int delete(Long id);

}
