package fr.feuzme.demo.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.feuzme.demo.models.Article;
import fr.feuzme.demo.repositories.ArticleRepo;
import fr.feuzme.demo.services.GenericCRUDService;

public class ArticleServiceImpl implements GenericCRUDService<Article> {
	@Autowired
	private ArticleRepo repository;

	@Override
	public Article findById(String id) {
		return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Article> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Article save(Article entity) {
		return this.repository.save(entity);
	}

	@Override
	public void deleteById(String id) {
		if (this.repository.existsById(id))
			this.repository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public Article update(Article entity) {
		Article dbArticle = this.repository.findById(entity.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (entity.getTitle() != null)
			dbArticle.setTitle(entity.getTitle());
		if (entity.getContent() != null)
			dbArticle.setContent(entity.getContent());

		return this.repository.save(dbArticle);
	}

}
