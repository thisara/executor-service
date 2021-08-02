package com.thisara.custom;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import con.thisara.tasks.CallableTask;
import con.thisara.tasks.Task;

public class CustomThreadPoolImpl {

	public static void main(String []args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = CustomThreadPool.newCustomThreadPool();
		
		//Runnable task - void return
		executorService.execute(new Task());
		
		//Callable task with String return
		Future<String> futureExpect = executorService.submit(new CallableTask());
		
		//Do some task while callble is running
		
		//This is a blocking operation, this will block the main thread until callable-task get completed
		String callableReturn = futureExpect.get();
	
		System.out.println("Callable task return : " + callableReturn);
		
		//start shutdown - execute all the tasks in the queue upto shutdown initiation
		executorService.shutdown();
		
		System.out.println("Is Thread Pool Shutdown : " + executorService.isShutdown());
		
		//if the pool shutdown this will throw rejectionexception
		executorService.execute(new Task());
		
		//await until all tasks are completed or timeout
		executorService.awaitTermination(10, TimeUnit.SECONDS);
		
		//Run only running tasks and return all the tasks in the queue unlike in shutdown
		List<Runnable> runnableTasks = executorService.shutdownNow();
		
		System.out.println("Is Thread Pool Terminated : " + executorService.isTerminated());
	}

}
