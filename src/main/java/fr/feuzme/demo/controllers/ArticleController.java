package fr.feuzme.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.feuzme.demo.models.Article;
import fr.feuzme.demo.services.GenericCRUDService;

@RestController
@CrossOrigin
@RequestMapping("articles")
public class ArticleController {
	@Autowired
	private GenericCRUDService<Article> service;
	
	@GetMapping("")
	public List<Article> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Article findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public Article save(@RequestBody Article entity) {
		return this.service.save(entity);
	}
	
	@PatchMapping("")
	public Article update(@RequestBody Article entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}
}
