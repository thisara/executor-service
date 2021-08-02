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
public class CachedThreadPoolImpl {

	public static void main(String args[]) {
		
		ExecutorService executorServiceCached = Executors.newCachedThreadPool();
		
		BlockingTaskQueue blockingTaskQueue = new BlockingTaskQueue();
		
		ArrayBlockingQueue<Task> arrayBlockingQueue = blockingTaskQueue.getBlockingQueue();
		
		int queueSize = arrayBlockingQueue.size();
		
		for(int x = 0; x < queueSize; x++) {
			
			Task task = arrayBlockingQueue.poll();
	
			if(task != null) {
				//Add the task in to the blocking queue of the pool
				executorServiceCached.execute(task);
			}else {
				System.out.println("Queue is empty.!");
			}
		}
		
		executorServiceCached.shutdown();
	}
}
