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

	public Process(int sizeInMemory) {
		this.id = UUID.randomUUID().toString();
		this.sizeInMemory = sizeInMemory;
//		Random r = new Random();
//		List<Integer> numbers = Arrays.asList(1, 2, 4, 6, 8, 10, 20, 50, 100);
//		this.sizeInMemory = numbers.get(r.nextInt(numbers.size()));
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
