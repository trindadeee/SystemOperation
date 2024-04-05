package so;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {

	private String id;
	private int sizeInMemory;
	private List<String> process;
	public static int count;
//	private static int instructionNumber = 7;
//	private static int timeToExecute = 5000;

	public Process(int sizeInMemory) {
		count++;
		this.id = "p" + count;
		this.sizeInMemory = sizeInMemory;
		this.process = this.getprocess();
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

}
