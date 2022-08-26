package com.article.articlewebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.article.articlewebservice.domaine.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    
}
