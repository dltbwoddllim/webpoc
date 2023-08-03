package com.example.crypdonutsweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @PostMapping("/author/register")
    public ResponseEntity<String> registerAuthor(@RequestBody Author author) {
        // Implementation to register an author
        // Replace Author with your actual Author model
        // You may use a service class to handle author registration logic
        // Return appropriate response status and message
        return ResponseEntity.ok("Author registered successfully");
    }

    @PostMapping("/author/delete")
    public ResponseEntity<String> deleteAuthor(@RequestParam("authorId") String authorId) {
        // Implementation to delete an author by their ID
        // Return appropriate response status and message
        return ResponseEntity.ok("Author deleted successfully");
    }

    @PostMapping("/author/article/write")
    public ResponseEntity<String> registerArticle(@RequestBody Article article) {
        // Implementation to allow registered writers to register articles
        // Return appropriate response status and message
        return ResponseEntity.ok("Article registered successfully");
    }

    @PostMapping("/author/article/modify")
    public ResponseEntity<String> modifyArticle(@RequestBody Article article) {
        // Implementation to allow editing of articles
        // Return appropriate response status and message
        return ResponseEntity.ok("Article modified successfully");
    }

    @PostMapping("/author/article/delete")
    public ResponseEntity<String> deleteArticle(@RequestParam("articleId") String articleId) {
        // Implementation to delete an article by its ID
        // Return appropriate response status and message
        return ResponseEntity.ok("Article deleted successfully");
    }
}