package com.sparsh.learning.fixedthreadpool;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author Prashant Swamy
 *
 */
public class TestTask implements Callable<String> {

	private int i;

	/**
	 * @param i
	 */
	public TestTask(int i) {
		this.i = i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public String call() {
		String str = null;
		try {
			Thread.sleep(5000);
			str = "Inside the run for " + i + " at " + new Date();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return str;
	}

}
