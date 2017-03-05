package com.sparsh.learning.fixedthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Prashant Swamy
 *
 */
public class ThreadFixedSchulderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		List<Future<String>> futures = new ArrayList<Future<String>>();
		for (int i = 0; i < 50; i++) {
			Future<String> future = executorService.submit(new TestTask(i));
			System.out.println("TestTask called for " + i);
			futures.add(future);
		}

		for (Future<String> future : futures) {
			try {
				String string = future.get();
				System.out.println(string);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();
	}

}
