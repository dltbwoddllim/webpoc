package com.example.crypdonutsweb.DAO;

import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle, t.date, t.text, t.tag " +
            "FROM article a " +
            "JOIN author au ON a.author_id = au.author_id " +
            "JOIN title t ON a.title_id = t.title_id " +
            "WHERE a.article_id = :articleId ", nativeQuery = true
    )
    ArticleEntity getArticle(Long articleId);

}