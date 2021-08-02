package con.thisara.tasks;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String>{

	private int taskId;
	
	@Override
	public String call() throws Exception {
		Thread.sleep(5000);
		System.out.println("Running callable task | TaskID : " + taskId);
		return "Callable task completed : " + taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getTaskId() {
		return taskId;
	}
}
