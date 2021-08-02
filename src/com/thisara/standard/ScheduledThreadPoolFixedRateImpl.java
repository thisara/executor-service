package com.thisara.standard;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import con.thisara.tasks.SheduledTask;

public class ScheduledThreadPoolFixedRateImpl {

	public static void main(String args[]) {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		
		ScheduledExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(coreCount);

		executorServiceScheduled.scheduleAtFixedRate(new SheduledTask(), 2, 1, TimeUnit.SECONDS);

	}
}
