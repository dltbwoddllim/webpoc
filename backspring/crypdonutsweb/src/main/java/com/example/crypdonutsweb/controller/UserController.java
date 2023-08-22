package com.example.crypdonutsweb.controller;


import com.example.crypdonutsweb.service.page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class UserController {

    @GetMapping("/main")
    public ResponseEntity<String> getLatestArticles() {
        String articles = page.getLatestArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/main/afterid/{id}")
    public ResponseEntity<String> getLatestArticles(@PathVariable("id") Long id) {
        String article = page.getArticleAfterid(id);
        if (article == null) {
            return ResponseEntity.badRequest().body("Article not found");
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<String> getArticle(@PathVariable("id") Long id) {

        String article = page.getArticle(id);
        if (article == null) {
            return ResponseEntity.badRequest().body("Article not found");
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<String> getArticleByTag(@PathVariable("tag") String tag) {

        String articles = page.getArticlesByTag(tag);
        if (articles.length()==2) {
            return ResponseEntity.badRequest().body("tag not found");
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/tag/{tag}/id/{id}")
    public ResponseEntity<String> getArticleByTagAfterId(@PathVariable("tag") String tag, @PathVariable("id") Long id) {

        String articles = page.getArticlesByTagAfterid(tag, id);
        if (articles.length()==2) {
            return ResponseEntity.badRequest().body("articles not found");
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<String> getArticleByAuthor(@PathVariable("id") Long id) {

        String articles = page.getArticlesByAuthor(id);

        if (articles.length()==2) {
            return ResponseEntity.badRequest().body("author not found");
        }
        return ResponseEntity.ok(articles);
    }

}