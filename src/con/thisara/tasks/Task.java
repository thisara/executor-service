package con.thisara.tasks;
/**
 * 
 * @author thisara
 *
 */
public class Task implements Runnable{

	private int taskId;
	
	@Override
	public void run() {
		
		double jobId = Math.random();
		
		System.out.println("Task started! - TaskID : " + this.taskId + " JobID : " + jobId);
		
		try {
			Thread.sleep(5000);
			System.out.println("Task executed! - ID : " + this.taskId + " JobID : " + jobId);
		} catch (InterruptedException e) {
			System.out.println("Task aborted! - ID : " + this.taskId + " JobID : " + jobId);
			e.printStackTrace();
		}
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getTaskId() {
		return taskId;
	}
	
}
