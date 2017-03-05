package com.sparsh.learning.accelerate.runnable;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author prashant.swamy
 *
 */
public class RunnableClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

		Random random = new Random();

		for (int i = 0; i < 30; i++) {
			Integer number = random.nextInt(9);
			System.out.println("Random Number at " + i + " " + number);
			FactorialCalculatorRunnable calculator = new FactorialCalculatorRunnable(number);
			Future future = executor.submit(calculator);
			try {
				if (future.get() != null) {
					System.out.println("There was some problem with " + number);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		// shut down the executor service now
		executor.shutdown();
	}

}
