package so;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Process {

	private String id;
	private int sizeInMemory;
	private List<String> process;
	public static int count;
	private int timeToExecute;
	private PriorityProcessType priority;

	public Process(int sizeInMemory) {
		count++;
		this.id = "p" + count;
		this.sizeInMemory = sizeInMemory;
		this.process = this.getprocess();
		Random random = new Random();
		List<Integer> listTime = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000);
		this.timeToExecute = listTime.get(random.nextInt(listTime.size()));
		PriorityProcessType[] listPriority = PriorityProcessType.values();
		this.priority = listPriority[random.nextInt(listPriority.length)];
	}

	public List<String> getprocess() {
		if (this.process == null) {
			this.process = new LinkedList<>();
			for (int i = 0; i < this.sizeInMemory; i++) {
				String spId = this.getId() + i;
				this.process.add(spId);
			}
		}
		return this.process;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSizeInMemory() {
		return sizeInMemory;
	}

	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}
	
	public int getTimeToExecute() {
		return timeToExecute;
	}

	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	
	public PriorityProcessType getPriority() {
		return priority;
	}

	public void setPriority(PriorityProcessType priority) {
		this.priority = priority;
	}


}
