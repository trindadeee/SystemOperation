package so;

import java.util.List;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {

	private String id;
	private int sizeInMemory;
	private int timeToExecute;
	private int priority;
	private List<Process> process;
	private int instructions;
	private AdressMemory adress;
	private String name;

	

	public Process(int sizeInMemory, String name) {
		this.id = UUID.randomUUID().toString();
		this.sizeInMemory = sizeInMemory;
		this.name = name;
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

	public AdressMemory getAdress() {
		return adress;
	}

	public void setAdress(AdressMemory adress) {
		this.adress = adress;
	}

}
