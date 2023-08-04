package com.example.crypdonutsweb.controller;


import com.example.crypdonutsweb.Entity.ArticleEntity;
import com.example.crypdonutsweb.service.mainpage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
public class UserController {

    @GetMapping("/main")
    public ResponseEntity<String> getLatestArticles() {
        String articles = mainpage.getLatestArticles();
        return ResponseEntity.ok(articles);
    }
}