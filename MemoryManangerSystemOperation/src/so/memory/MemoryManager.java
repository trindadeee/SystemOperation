package so.memory;

import so.Process;

public class MemoryManager {

	private String[] memory;
	private Strategy strategy;

	public MemoryManager(Strategy strategy) {
		this.memory = new String[128];
		this.strategy = strategy;
	}

	public void write(Process p) {
		if (strategy.equals(strategy.FIRST_FIT)) {
			this.writeUsingFirstFit(p);
		} else if (strategy.equals(strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		} else if (strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWirstFit(p);
		}
	}

	private void writeUsingWirstFit(Process p) {

	}

	private void writeUsingBestFit(Process p) {

	}

	private void writeUsingFirstFit(Process p) {
		int actualSize = 0;
		for (int i = 0; i < memory.length; i++) {
			if (i == (memory.length - 1)) {
				if (actualSize > 0) {
					if (p.getSizeInMemory() <= actualSize) {
						int start = (i - actualSize);
						int end = i;
						for (int j = start; j < p.getSizeInMemory(); j++) {
							memory[j] = p.getId();
						}
						break;
					}
				}
			} else if (memory[i] == null) {
				actualSize++;
			} else {
				if (actualSize > 0) {
					if (p.getSizeInMemory() <= actualSize) {
						int start = i - actualSize;
						int end = i - 1;
						for (int j = start; j <= end; j++) {
							memory[j] = p.getId();
						}
						break;
					}
				}
				actualSize = 0;
			}
		}
		printMemoryStatus();

	}

	private void printMemoryStatus() {
		for (int i = 0; i < memory.length; i++) {
			System.out.print(memory[i] + " | ");

		}
	}
}
