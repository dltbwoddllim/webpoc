package com.example.crypdonutsweb.DTO;

import java.time.LocalDate;

public class ArticleDTO {
    private Long article_id;
    private Long author_id;
    private Long title_id;
    private String name;
    private String title;
    private String subtitle;

    private String imageurl;
    private String imagesource;
    private String text;
    private LocalDate date;
    private String tag;


    public ArticleDTO(Long articleId, Long authorId, Long titleId, String name, String title, String subtitle, String imageurl, String imagesource, LocalDate date, String tag, String text) {
        this.article_id = articleId;
        this.author_id = authorId;
        this.title_id = titleId;
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
        this.imageurl = imageurl;

        this.date = date;
        this.text = text;
        this.tag = tag;
    }

    public ArticleDTO() {
    }

    //getter setter
    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getTitle_id() {
        return title_id;
    }

    public void setTitle_id(Long title_id) {
        this.title_id = title_id;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //tostring
    @Override
    public String toString() {
        return "ArticleDTO{" +
                "article_id=" + article_id +
                ", author_id=" + author_id +
                ", title_id=" + title_id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", imagesource='" + imagesource + '\'' +
                ", date=" + date +
                ", tag='" + tag + '\'' +
                '}';
    }

    //tojson
    public String toJson() {
        return "{" +
                "\"article_id\":" + article_id +
                ", \"author_id\":" + author_id +
                ", \"title_id\":" + title_id +
                ", \"name\":\"" + name + '\"' +
                ", \"title\":\"" + title + '\"' +
                ", \"subtitle\":\"" + subtitle + '\"' +
                ", \"imageurl\":\"" + imageurl + '\"' +
                ", \"imagesource\":\"" + imagesource + '\"' +
                ", \"date\":\"" + date + '\"' +
                ", \"tag\":\"" + tag + '\"' +
                ", \"text\":\"" + text + '\"' +
                '}';
    }
}