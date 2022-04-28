package br.com.estudandoemcasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsConcurrentApplication.class, args);

		Runnable task = () -> System.out.println("Olá, eu sou uma thread!" + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			new Thread(task).start();
		}
	}

}
