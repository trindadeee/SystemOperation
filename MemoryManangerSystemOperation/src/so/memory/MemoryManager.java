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
			this.writeUsingBirstFit(p);
		} else if (strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWirstFit(p);
		} else if (strategy.equals(strategy.PAGING)) {
			this.writeUsingPaging(p);
		}
	}

	private void writeUsingPaging(Process p) {
		
	}

	private void writeUsingWirstFit(Process p) {
		
	}

	private void writeUsingBirstFit(Process p) {
			
	}

	private void writeUsingFirstFit(Process p) {
		
	}
	
	private void printMemoryStatus() {
		for(int i = 0; i < memory.length; i++) {
			System.out.println();
			
		}
	}
}
