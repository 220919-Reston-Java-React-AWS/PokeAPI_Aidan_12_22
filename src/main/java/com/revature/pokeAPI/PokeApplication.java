package com.revature.pokeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeApplication.class, args);
	}

	// Notify when the application is up and running through the console
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("\n\t\t\t-----====== APPLICATION ACTIVE ======-----\n");
	}


}
