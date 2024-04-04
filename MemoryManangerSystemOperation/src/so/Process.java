package so;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {

	private String id;
	private int sizeInMemory;
	private List<SubProcess> process;
	public static int count;
	private static int instructionNumber = 7;
	private static int timeToExecute = 5000;
	private String name;

	public Process(int sizeInMemory, String name) {
		count++;
		this.id = "p" + count;
		this.sizeInMemory = sizeInMemory;
		this.process = this.getprocess();
		this.name = name;
	}

	private List<SubProcess> getprocess() {
		if (this.process == null) {
			this.process = new LinkedList<>();
			for (int i = 0; i < this.sizeInMemory; i++) {
				this.process.add(new SubProcess(this.getId(), instructionNumber, timeToExecute));
			}
		}
		return this.process;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
