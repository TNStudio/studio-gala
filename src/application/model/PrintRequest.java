package application.model;

public class PrintRequest {
	
	private int number;
	private String path;
	private boolean workDone = false;
	
	public PrintRequest(int number, String path){
		this.number = number;
		this.path=path;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isWorkDone() {
		return workDone;
	}

	public void setWorkDone(boolean workDone) {
		this.workDone = workDone;
	}
	
	

}
