package com.thisara.custom;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {

	private static int corePoolSize = 10;
	private static int maximumPoolSize = 100;
	private static int keepAliveTime = 120;

	public static ExecutorService newCustomThreadPool() {
		
		return new ThreadPoolExecutor(
				corePoolSize, 
				maximumPoolSize, 
				keepAliveTime, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(300),
				new CustomRejectionHandller());
	}
}
