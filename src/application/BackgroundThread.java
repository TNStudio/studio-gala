package application;

import javafx.concurrent.Task;

public class BackgroundThread implements Runnable{
	Thread thread;
	Task<?> task;
	
	public BackgroundThread(Task<?> task) {
		thread = new Thread(this);
		this.task = task;
	}

	@Override
	public void run() {
		task.run();		
	}

}
