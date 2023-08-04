package com.example.crypdonutsweb.DAO;

import java.util.List;
import java.util.stream.Collectors;

import com.example.crypdonutsweb.DTO.ArticleDTO;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "ORDER BY t.date DESC\n" +
            "LIMIT 3;", nativeQuery = true)
    List<ArticleEntity> findLatestArticles();
}

