//package com.example.springboothttpclient.ws;
//
//
//import com.example.springboothttpclient.beans.Post;
//import com.example.springboothttpclient.services.facade.PostService;
//
//import java.util.List;
//
//@RestControler
//@RequestMapping("/api/posts")
//public class PostController {
//
//    private PostService postService;
//
//    public PostController(PostService postService) {
//        postService = postService;
//    }
//
//    https://localhost:8080/api/posts/
//    @GetMapping("/")
//    public List<Post> findAll() {
//        return postService.findAll();
//    }
//
//    https://localhost:8080/api/posts/1
//    @GetMapping("/{id}")
//    public Post findById(@PathVariable Long id) {
//        return postService.findById(id);
//    }
//
//    https://localhost:8080/api/posts/
//    @PostMapping("/")
//    public Post save(@RequestBody Post post) {
//        return postService.save(post);
//    }
//
//    https://localhost:8080/api/posts/
//    @PutMapping("/")
//    public Post update(@RequestBody Post post,@PathVariable Long id) {
//        return postService.update(post, id);
//    }
//
//    https://localhost:8080/api/posts/1
//    @DeleteMapping("/{id}")
//    public int delete(@PathVariable Long id) {
//        return postService.delete(id);
//    }
//}
