package fr.feuzme.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.feuzme.demo.models.User;

public interface UserRepo extends MongoRepository<User, String> {

}
