package com.example.healthsystem;

import com.example.healthsystem.service.DocteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealthSystemApplication implements CommandLineRunner {

	@Autowired
	DocteurService docteurService;
	public static void main(String[] args) {
		SpringApplication.run(HealthSystemApplication.class, args);
	}

	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		String text = "Your development server is working";

		return String.format(text);
	}

	@Override
	public void run(String... args) throws Exception {
		docteurService.initiateDocteurListe();
	}
}
