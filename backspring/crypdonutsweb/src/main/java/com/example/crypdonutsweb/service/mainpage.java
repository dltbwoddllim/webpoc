package com.example.crypdonutsweb.service;

import com.example.crypdonutsweb.DAO.ArticleRepository;
import com.example.crypdonutsweb.DTO.ArticleDTO;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class mainpage {
    private static ArticleRepository articleRepository;
    private static ArticleMapper articleMapper;

    @Autowired
    public mainpage(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    public static String getLatestArticles() {
        //데이터 베이스에서 데이터 가져오기
        List<ArticleEntity> articleEntities = articleRepository.findLatestArticles();

        // Entity 리스트를 DTO 리스트로 변환
        List<ArticleDTO> articleDTOs = articleMapper.mapEntityListToDTOList(articleEntities);

        //dtos print
        // DTO 리스트를 JSON으로 변환
        String articlesJson = articleMapper.convertDTOsToJson(articleDTOs);

        return articlesJson;
    }
}
