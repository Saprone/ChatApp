package edu.fontys.chatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAppBackend {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ChatAppBackend.class, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}