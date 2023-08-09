package com.example.crypdonutsweb.service;

import com.example.crypdonutsweb.DTO.ArticleDTO;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {
    public ArticleDTO mapEntityToDTO(ArticleEntity entity) {
        ArticleDTO dto = new ArticleDTO(
                entity.getArticleId(),
                entity.getAuthorId(),
                entity.getTitleId(),
                entity.getName(),
                entity.getTitle(),
                entity.getSubtitle(),
                entity.getDate(),
                entity.getTag(),
                entity.getText()
        );
        System.out.println(dto.toString());
        return dto;
    }


    public String convertDTOsToJson(ArticleDTO dto) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("["); // Start of JSON array

        jsonBuilder.append(dto.toJson());

        jsonBuilder.append("]"); // End of JSON array

        return jsonBuilder.toString();
    }

}
