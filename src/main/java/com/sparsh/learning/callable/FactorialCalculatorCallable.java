package com.sparsh.learning.accelerate.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author prashant.swamy
 *
 */
public class FactorialCalculatorCallable implements Callable<Integer> {

	private Integer number;

	public FactorialCalculatorCallable(Integer number) {
		this.number = number;
	}

	/**
	 * Call method will calculate the factorial and sleeps for the number of milliseconds equal to the factorial result.
	 */
	public Integer call() throws Exception {
		int result = 1;
		if ((number == 0) || (number == 1)) {
			result = 1;
		} else {
			for (int i = 2; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(result);
			}
		}
		System.out.println(Thread.currentThread().getName() + " Result for number - " + number + " -> " + result);
		return result;
	}

}
