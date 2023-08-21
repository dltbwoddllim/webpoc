package com.example.crypdonutsweb.DAO;

import java.util.List;

import com.example.crypdonutsweb.Entity.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticlesEntity, Long> {
    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle, t.imageurl, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "ORDER BY a.article_id DESC\n" +
            "LIMIT 9;", nativeQuery = true)
    List<ArticlesEntity> getLatestArticles();

    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle,t.imageurl, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "WHERE t.tag = :tag\n" +
            "ORDER BY t.date DESC\n" +
            "LIMIT 9;", nativeQuery = true)
    List<ArticlesEntity> getArticlesByTag(String tag);

    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle,t.imageurl, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "WHERE a.author_id = :authorId\n" +
            "ORDER BY t.date DESC\n" +
            "LIMIT 9;", nativeQuery = true)
    List<ArticlesEntity> getArticlesByAuthor(Long authorId);

    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle,t.imageurl, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "WHERE a.article_id < :article_id\n" +
            "ORDER BY t.date DESC\n" +
            "LIMIT 9;", nativeQuery = true)
    List<ArticlesEntity> getArticlesAfterArticleid(Long article_id);

    @Query(value = "SELECT a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle,t.imageurl, t.date, t.tag\n" +
            "FROM article a\n" +
            "JOIN author au ON a.author_id = au.author_id\n" +
            "JOIN title t ON a.title_id = t.title_id\n" +
            "WHERE a.article_id < :article_id AND t.tag = :tag\n" +
            "ORDER BY t.date DESC\n" +
            "LIMIT 9;", nativeQuery = true)
    List<ArticlesEntity> getArticlesByTagAfterid(String tag, Long article_id);

}