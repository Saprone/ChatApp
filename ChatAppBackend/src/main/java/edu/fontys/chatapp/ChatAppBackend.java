package edu.fontys.chatapp;

import edu.fontys.chatapp.model.Role;
import edu.fontys.chatapp.model.User;
import edu.fontys.chatapp.service.UserService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ChatAppBackend {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ChatAppBackend.class, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Piet P", "piet", "1234", "room1", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Kees K", "kees", "1234", "room2", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Hans H", "hans", "1234", "room1", new ArrayList<>(), new ArrayList<>()));

			userService.addRoleToUser("piet", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("piet", "ROLE_ADMIN");
			userService.addRoleToUser("kees", "ROLE_MANAGER");
			userService.addRoleToUser("hans", "ROLE_USER");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	public Info apiInfo() {
		Info info = new Info();
		info.title("Springdoc Chat Application API").version("1.0");

		return info;
	}
}