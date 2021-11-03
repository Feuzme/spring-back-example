package fr.feuzme.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document
public class Article {
	@Id
	private String id;
	private String title;
	private String content;
}
