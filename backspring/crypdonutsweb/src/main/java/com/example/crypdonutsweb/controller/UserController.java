package com.example.crypdonutsweb.controller;


import com.example.crypdonutsweb.service.page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class UserController {

    @GetMapping("/main")
    public ResponseEntity<String> getLatestArticles() {
        String articles = page.getLatestArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<String> getArticle(@PathVariable("id") Long id) {

        String article = page.getArticle(id);
        if (article == null) {
            return ResponseEntity.badRequest().body("Article not found");
        }
        return ResponseEntity.ok(article);
    }

}