package com.example.crypdonutsweb;

import com.example.crypdonutsweb.DAO.ArticleRepository;
import com.example.crypdonutsweb.DAO.ArticlesRepository;
import com.example.crypdonutsweb.Entity.ArticleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CrypdonutswebApplicationTests {

	@Test
	void contextLoads() {

	}
	@Autowired
	private ArticleRepository articleRepository;

	@Test
	public void testGetArticle() {

		Long articleId = 1L; // 원하는 article id 값
		ArticleEntity result = articleRepository.getArticle(articleId);

		System.out.print("Result: " + result.toString());

	}
}
