package fr.feuzme.demo.models;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private String id;
	private String nom;
	private String prenom;
}
