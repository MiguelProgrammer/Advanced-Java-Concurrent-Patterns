package br.com.estudandoemcasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsConcurrentApplication.class, args);
		
		Runnable task = () -> System.out.println("Hello world!");
		Thread thread = new Thread(task);
		
		thread.start();
		
	}

}
