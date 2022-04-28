package br.com.estudandoemcasa;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PatternsConcurrentApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		// Runnable task = () -> System.out.println("Olá, eu sou uma thread!" +
		// Thread.currentThread().getName());

		Callable<String> task = () -> {
			//Thread.sleep(300);
			//return "Olá, eu sou uma thread!" + Thread.currentThread().getName();
			
			throw new IllegalStateException("I throwan exceptionin thread " + Thread.currentThread().getName());
		};

		ExecutorService executor = Executors.newFixedThreadPool(4);
		try {
			for (int i = 0; i < 10; i++) {
				// new Thread(task).start();
				// service.execute(task);
				Future<String> future = executor.submit(task);
				System.out.println("I get: " + future.get(100, TimeUnit.MILLISECONDS));
			}
		} finally {
			executor.shutdown();
		}

	}

}
