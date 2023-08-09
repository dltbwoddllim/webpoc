package com.example.crypdonutsweb.service;

import com.example.crypdonutsweb.DAO.ArticleRepository;
import com.example.crypdonutsweb.DAO.ArticlesRepository;
import com.example.crypdonutsweb.DTO.ArticleDTO;
import com.example.crypdonutsweb.DTO.ArticlesDTO;
import com.example.crypdonutsweb.Entity.ArticlesEntity;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class page {
    private static ArticlesRepository articlesRepository;
    private static ArticleRepository articleRepository;
    private static ArticlesMapper articlesMapper;

    private static ArticleMapper articleMapper;

    @Autowired
    public void mainpage(ArticlesRepository articlesRepository, ArticleRepository articleRepository, ArticlesMapper articlesMapper, ArticleMapper articleMapper) {
        this.articlesRepository = articlesRepository;
        this.articleRepository = articleRepository;
        this.articlesMapper = articlesMapper;
        this.articleMapper = articleMapper;
    }

    public static String getLatestArticles() {
        //데이터 베이스에서 데이터 가져오기
        List<ArticlesEntity> articleEntities = articlesRepository.getLatestArticles();

        // Entity 리스트를 DTO 리스트로 변환
        List<ArticlesDTO> articleDTOs = articlesMapper.mapEntityListToDTOList(articleEntities);

        //dtos print
        // DTO 리스트를 JSON으로 변환
        String articlesJson = articlesMapper.convertDTOsToJson(articleDTOs);

        return articlesJson;
    }

    public static String getArticle(Long id){
        //데이터 베이스에서 데이터 가져오기
        ArticleEntity articleEntity = articleRepository.getArticle(id);
        //object key, value print

        // Entity 리스트를 DTO 리스트로 변환
        ArticleDTO articleDTO = articleMapper.mapEntityToDTO(articleEntity);

        //dtos print
        // DTO 리스트를 JSON으로 변환
        String articleJson = articleDTO.toJson();
        System.out.println(articleJson);

        return articleJson;
    }
}
