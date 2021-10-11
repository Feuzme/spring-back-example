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

import fr.feuzme.demo.models.User;
import fr.feuzme.demo.services.GenericCRUDService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
	@Autowired
	private GenericCRUDService<User> service;
	
	@GetMapping("")
	public List<User> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public User findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@PostMapping("")
	public User save(@RequestBody User entity) {
		return this.service.save(entity);
	}
	
	@PatchMapping("")
	public User update(@RequestBody User entity) {
		return this.service.update(entity);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		this.service.deleteById(id);
	}
}
