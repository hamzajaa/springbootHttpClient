package com.example.springboothttpclient.runner;

import com.example.springboothttpclient.beans.*;
import com.example.springboothttpclient.services.facade.*;
import com.example.springboothttpclient.utils.HttpClientHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private PostService postService;
    private AddressService addressService;
    private GeoService geoService;
    private UserService userService;
    private CompanyService companyService;
    private CommentService commentService;

    public Runner(PostService postService, AddressService addressService, GeoService geoService, UserService userService, CompanyService companyService, CommentService commentService) {
        this.postService = postService;
        this.addressService = addressService;
        this.geoService = geoService;
        this.userService = userService;
        this.companyService = companyService;
        this.commentService = commentService;
    }


    @Override
    public void run(String... args) throws Exception {

        List<User> userList = HttpClientHelper.getEntities("https://jsonplaceholder.typicode.com/users", User.class);

        userList.forEach(user -> userService.save(user));

        List<Post> postList = HttpClientHelper.getEntities("https://jsonplaceholder.typicode.com/posts", Post.class);

        postList.forEach(post -> postService.save(post));

        List<Comment> commentList = HttpClientHelper.getEntities("https://jsonplaceholder.typicode.com/comments", Comment.class);

        commentList.forEach(comment -> commentService.save(comment));

    }
}
