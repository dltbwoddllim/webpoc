package com.example.crypdonutsweb.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class ArticlesEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "article_id")
        private Long articleId;

        @Column(name = "author_id")
        private Long authorId;

        @Column(name = "title_id")
        private Long titleId;

        private String name;
        private String title;
        private String subtitle;
        private String imageurl;
        private LocalDate date;
        private String tag;

        // 생성자, Getter, Setter 등 필요한 메서드를 추가해주세요.

        // 기본 생성자
        public ArticlesEntity() {
        }

        // 생성자
        public ArticlesEntity(Long articleId, Long authorId, Long titleId, String name, String title,
                              String subtitle, String imageurl, LocalDate date, String tag) {
            this.articleId = articleId;
            this.authorId = authorId;
            this.titleId = titleId;
            this.name = name;
            this.title = title;
            this.subtitle = subtitle;
            this.imageurl = imageurl;
            this.date = date;
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

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
}