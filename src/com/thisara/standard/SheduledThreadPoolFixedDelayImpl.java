package com.thisara.standard;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import con.thisara.tasks.SheduledTask;

/**
 * 
 * @author thisara
 *
 */
public class SheduledThreadPoolFixedDelayImpl {

	public static void main(String args[]) {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		
		ScheduledExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(coreCount);

		//Add the task in to the blocking queue of the pool
		executorServiceScheduled.scheduleWithFixedDelay(new SheduledTask(), 2, 3, TimeUnit.SECONDS);
		
	}
}
