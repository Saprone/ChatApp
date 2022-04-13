package edu.fontys.chatapp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	public Info apiInfo() {
		Info info = new Info();
		info.title("Springdoc Chat Application API").version("1.0");

		return info;
	}
}