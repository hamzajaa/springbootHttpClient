package com.example.springboothttpclient;

import com.example.springboothttpclient.beans.Post;
import com.example.springboothttpclient.services.facade.PostService;
import com.example.springboothttpclient.utils.HttpClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootHttpClientApplication   {

    @Autowired
    private PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHttpClientApplication.class, args);

    }

}
