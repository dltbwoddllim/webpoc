package com.example.crypdonutsweb.service;

import com.example.crypdonutsweb.DTO.ArticlesDTO;
import com.example.crypdonutsweb.Entity.ArticlesEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticlesMapper {
    public ArticlesDTO mapEntityToDTO(ArticlesEntity entity) {
        ArticlesDTO dto = new ArticlesDTO(
                entity.getArticleId(),
                entity.getAuthorId(),
                entity.getTitleId(),
                entity.getName(),
                entity.getTitle(),
                entity.getSubtitle(),
                entity.getDate(),
                entity.getTag()
        );
        return dto;
    }

    public List<ArticlesDTO> mapEntityListToDTOList(List<ArticlesEntity> entityList) {
        return entityList.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    public String convertDTOsToJson(List<ArticlesDTO> dtoList) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("["); // Start of JSON array

        for (int i = 0; i < dtoList.size(); i++) {
            ArticlesDTO dto = dtoList.get(i);
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
