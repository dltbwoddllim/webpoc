package com.example.crypdonutsweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @GetMapping("/main")
    public ResponseEntity<List<Article>> getLatestArticles() {
        // Implementation to fetch latest articles by category
//        List<Article> articles = ...; // Your implementation to get latest articles
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/tag")
    public ResponseEntity<List<Article>> getArticlesByTag(@RequestParam("tagid") String tagId,
                                                          @RequestParam("page") int page) {
//        // Implementation to fetch articles by tag with pagination
//        List<Article> articles = ...; // Your implementation to get articles by tag
//        return ResponseEntity.ok(articles);
    }

    @GetMapping("/article")
    public ResponseEntity<Article> getArticleById(@RequestParam("articleid") String articleId) {
        // Implementation to fetch an article by its ID
//        Article article = ...; // Your implementation to get the article by ID
//        if (article != null) {
//            return ResponseEntity.ok(article);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }
}