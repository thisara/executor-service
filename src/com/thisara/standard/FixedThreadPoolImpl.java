package com.thisara.standard;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thisara.queue.BlockingTaskQueue;

import con.thisara.tasks.Task;

/**
 * 
 * @author thisara
 *
 */
public class FixedThreadPoolImpl {

	public static void main(String []args) {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		
		BlockingTaskQueue blockingTaskQueue = new BlockingTaskQueue();
		
		ArrayBlockingQueue<Task> arrayBlockingQueue = blockingTaskQueue.getBlockingQueue();
		
		ExecutorService executorServiceFixed = Executors.newFixedThreadPool(coreCount);
		
		int queueSize = arrayBlockingQueue.size();
		
		for(int x = 0; x < queueSize; x++) {
			
			Task task = arrayBlockingQueue.poll();
	
			if(task != null) {
				//Add the task in to the blocking queue of the pool
				executorServiceFixed.execute(task);
			}else {
				System.out.println("Queue is empty.!");
			}
		}
		executorServiceFixed.shutdown();
	}	
}
