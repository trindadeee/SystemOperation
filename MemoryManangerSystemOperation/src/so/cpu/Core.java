package so.cpu;

import so.SubProcess;

public class Core implements Runnable {

	private int id;
	private SubProcess currentSubprocess;
	private int numOfInstructionsClock;
	private int count;

	public Core(int id, int numOfInstructionsClock) {
		this.id = id;
		this.numOfInstructionsClock = numOfInstructionsClock;
	}

	@Override
	public void run() {
		count += numOfInstructionsClock;
		if (count >= this.currentSubprocess.getInstructions()) {
			this.finishExecution();
		}
	}

	private void finishExecution() {
		this.count = 0;
		this.currentSubprocess = null;
	}

	public SubProcess getCurrentSubprocess() {
		return currentSubprocess;
	}

	public void setCurrentSubprocess(SubProcess currentSubprocess) {
		this.currentSubprocess = currentSubprocess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
