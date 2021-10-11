package fr.feuzme.demo.services.servicesImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import fr.feuzme.demo.models.User;
import fr.feuzme.demo.repositories.UserRepo;
import fr.feuzme.demo.services.GenericCRUDService;

public class UserServiceImpl implements GenericCRUDService<User> {
	@Autowired
	private UserRepo repository;

	@Override
	public User findById(String id) {
		return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User save(User entity) {
		Date dateNaissance = new Date(); //TODO
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
	public User update(User entity) {
		User dbUser = this.repository.findById(entity.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		if (entity.getNom() != null)
			dbUser.setNom(entity.getNom());
		if (entity.getPrenom() != null)
			dbUser.setPrenom(entity.getPrenom());
		if (entity.getDateNaissance() != null)
			dbUser.setDateNaissance(entity.getDateNaissance());
		if (entity.getTelephone() != null)
			dbUser.setTelephone(entity.getTelephone());

		return this.repository.save(dbUser);
	}

}
