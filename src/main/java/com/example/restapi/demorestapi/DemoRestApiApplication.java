package com.example.restapi.demorestapi;

import com.example.restapi.demorestapi.model.Client;
import com.example.restapi.demorestapi.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClientRepository clientRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Client user = new Client();
				user.setName(name);
				user.setEmail(name.toLowerCase() + "@domain.com");
				clientRepository.save(user);
			});
			clientRepository.findAll().forEach(System.out::println);
		};
	}

}
