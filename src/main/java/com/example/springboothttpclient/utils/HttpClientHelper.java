package com.example.springboothttpclient.utils;

import com.example.springboothttpclient.beans.Post;
import com.example.springboothttpclient.dao.PostDao;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class HttpClientHelper {


    public static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Post> getPosts() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // parse json into objects
        ObjectMapper mapper = new ObjectMapper();
        List<Post> posts = mapper.readValue(response.body(), new TypeReference<List<Post>>() {
        });

        return posts;
    }

    public static <E> List<E> getEntities(String url, Class<E> eClass) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url))
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        // Instantiate ObjectMapper.
        ObjectMapper objectMapper = new ObjectMapper();

        String body = response.body();

        List<E> resultList = objectMapper
                .readValue(body, objectMapper.getTypeFactory().constructCollectionType(List.class, eClass));


        return resultList;
    }


}
