package com.example.crypdonutsweb.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "article")
public class ArticleEntity {
//    Result: 1,1,1,John Doe,Introduction to SQL,https://assets.digitalocean.com/articles/how-to-use-sql-header/SQL-header-image.jpg,2023-08-04,In this tutorial, we will...,SQL

    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "title_id")
    private Long titleId;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;
    private String imageurl;
    private String imagesource;
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "content")
    private String text;

    @Column(name = "tag")
    private String tag;
    // 생성자, Getter, Setter 등 필요한 메서드를 추가해주세요.

    // 기본 생성자
    public ArticleEntity() {

    }
    // 생성자 a.article_id, a.author_id, a.title_id, au.name, t.title, t.subtitle, t.date, t.text, t.tag
    public ArticleEntity(Long articleId, Long authorId, Long titleId, String name, String title,
                         String subtitle, String imageurl, String imagesource, LocalDate date, String text, String tag) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.titleId = titleId;
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
        this.imageurl = imageurl;
        this.imagesource = imagesource;
        this.date = date;
        this.text = text;
        this.tag = tag;
    }

    // Getter, Setter
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImagesource() {
        return imagesource;
    }

    public void setImagesource(String imagesource) {
        this.imagesource = imagesource;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
