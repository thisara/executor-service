package con.thisara.tasks;
import java.util.concurrent.ArrayBlockingQueue;

import com.thisara.queue.BlockingTaskQueue;

public class SheduledTask implements Runnable{
	
	BlockingTaskQueue blockingTaskQueue = new BlockingTaskQueue();
	
	@Override
	public void run() {
		
		double scheduleId = Math.random();
		
		ArrayBlockingQueue<Task> arrayBlockingQueue = blockingTaskQueue.getBlockingQueue();
		
		int queueSize = arrayBlockingQueue.size();
		
		System.out.println("Running the scheduled task.! | ScheduleID : " + scheduleId);
		
		for(int x = 0; x < queueSize; x++) {
			
			Task task = arrayBlockingQueue.poll();
			
			if(task != null) {
				
				//Delegate access and process queue, or the queue elements could process here.
				new Thread(task).start(); 
				
				//Process heavy iteration to test the running delay.
				for(int y = 0; y < 80000000; y++) {
					int z = y%6;
				}
				
				System.out.println("Scheduled Task Executed : " + " | ScheduleID : " + scheduleId + " | TaskID : " + task.getTaskId());
				
			}else {
				System.out.println("Queue is empty.!" + " | ScheduleID : " + scheduleId);
			}
		}
	}
}
