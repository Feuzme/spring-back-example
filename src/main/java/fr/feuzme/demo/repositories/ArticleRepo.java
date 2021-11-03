package fr.feuzme.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.feuzme.demo.models.Article;

public interface ArticleRepo extends MongoRepository<Article, String>{

}
