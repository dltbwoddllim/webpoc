package com.example.crypdonutsweb.service;

import com.example.crypdonutsweb.DTO.ArticleDTO;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                entity.getTag()
        );
        System.out.println(dto.toString());
        return dto;
    }

    public List<ArticleDTO> mapEntityListToDTOList(List<ArticleEntity> entityList) {
        return entityList.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public String convertDTOsToJson(List<ArticleDTO> dtoList) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("["); // Start of JSON array

        for (int i = 0; i < dtoList.size(); i++) {
            ArticleDTO dto = dtoList.get(i);
            jsonBuilder.append(dto.toJson());

            // Add comma for all elements except the last one
            if (i < dtoList.size() - 1) {
                jsonBuilder.append(",");
            }
        }

        jsonBuilder.append("]"); // End of JSON array

        return jsonBuilder.toString();
    }

}
