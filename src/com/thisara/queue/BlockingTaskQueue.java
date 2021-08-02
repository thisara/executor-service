package com.thisara.queue;
import java.util.concurrent.ArrayBlockingQueue;

import con.thisara.tasks.Task;

/**
 * 
 * @author thisara
 *
 */
public class BlockingTaskQueue {

	public ArrayBlockingQueue<Task> arrayBlockingQueue = new ArrayBlockingQueue<Task>(2);
	
	public synchronized ArrayBlockingQueue<Task> getBlockingQueue() {
		
		for(int x = 0 ; x < 2; x++) {
			
			Task task = new Task();
			
			task.setTaskId(x);
			
			arrayBlockingQueue.add(task);
		}
		
		return arrayBlockingQueue;
	}
}
