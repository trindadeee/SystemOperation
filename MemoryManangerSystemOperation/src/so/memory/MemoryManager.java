package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import so.Process;

public class MemoryManager {

	private String[] memory;
	private Hashtable<String, List<FrameMemory>> logicalMemory;
	private int pageSize;
	private Strategy strategy;

	public MemoryManager(Strategy strategy, int pageSize) {
		this.memory = new String[12];
		this.pageSize = pageSize;
		this.strategy = strategy;
		logicalMemory = new Hashtable<>();
	}

	public MemoryManager(Strategy strategy) {
		this(strategy, 2);
	}

	public void write(Process p) {
		if (strategy.equals(strategy.FIRST_FIT)) {
			this.writeUsingFirstFit(p);
		} else if (strategy.equals(strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		} else if (strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWorstFit(p);
		}
	}
	
	public void deleteProcess(Process p) {
	    for (int i = 0; i < memory.length; i++) {
	        if (memory[i] != null && memory[i].equals(p.getId())) {
	            // Encontramos uma posição ocupada pelo processo a ser excluído
	            memory[i] = null; // Liberando a posição na memória
	        }
	    }
	    System.out.println("Processo " + p.getId() + " removido da memória.");
	    printMemoryStatus(); // Exibe o status atual da memória após a exclusão
	}

	private void writeUsingWorstFit(Process p) {
		int maxSize = -1;
		int start = -1;
		int i = 0;

		while (true) {
			int j;
			while (i < memory.length) {
				if (memory[i] == null) {
					for (j = i; j < memory.length && memory[j] == null; ++j) {
					}

					int blockSize = j - i;
					if (blockSize >= p.getSizeInMemory() && blockSize > maxSize) {
						maxSize = blockSize;
						start = i;
					}

					i = j;
				} else {
					++i;
				}
			}

			if (start != -1) {
				i = start + p.getSizeInMemory() - 1;

				for (j = start; j <= i; ++j) {
					memory[j] = p.getId();
				}

				printMemoryStatus();
			} else {
				System.out.println("Sem espaço suficiente para alocar o processo: " + p.getId());
			}

			return;
		}
	}

	private void writeUsingBestFit(Process p) {
		int minSize = Integer.MAX_VALUE;
		int start = -1;

		for (int i = 0; i < memory.length;) {
			if (memory[i] == null) {
				int j = i;
				while (j < memory.length && memory[j] == null) {
					j++;
				}
				int blockSize = j - i;
				if (blockSize >= p.getSizeInMemory() && blockSize < minSize) {
					minSize = blockSize;
					start = i;
				}
				i = j + 1;
			} else {
				i++;
			}
		}

		if (start != -1) {
			int end = start + p.getSizeInMemory() - 1;
			for (int j = start; j <= end; j++) {
				memory[j] = p.getId();
			}
			printMemoryStatus();
		} else {
			System.out.println("Não há espaço suficiente na memória para alocar o processo: " + p.getId());
		}

	}

	private void writeUsingFirstFit(Process p) {
		int actualSize = 0;
		for (int i = 0; i < memory.length; i++) {
			if (i == (memory.length - 1)) {
				if (actualSize > 0) {
					if (p.getSizeInMemory() <= actualSize) {
						int start = (i - actualSize);
						for (int j = start; j < start + p.getSizeInMemory(); j++) {
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
		System.out.println("------------------------------------------------------");
		printMemoryStatus();
		System.out.println("Memoria atual");
	}

	private void printMemoryStatus() {
		for (int i = 0; i < memory.length; i++) {
			System.out.println(memory[i] + " | ");

		}
	}
}
