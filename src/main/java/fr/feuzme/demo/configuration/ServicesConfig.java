package fr.feuzme.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.feuzme.demo.models.User;
import fr.feuzme.demo.services.GenericCRUDService;
import fr.feuzme.demo.services.servicesImpl.UserServiceImpl;

@Configuration
public class ServicesConfig {

	@Bean
	public GenericCRUDService<User> userServiceFactory() {
		return new UserServiceImpl();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setVisibility(
						VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
	}
}
