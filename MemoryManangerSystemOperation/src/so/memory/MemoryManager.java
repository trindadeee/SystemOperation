package so.memory;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import so.Process;
import so.SubProcess;

public class MemoryManager {

	private SubProcess[][] memory;
	private Hashtable<String, FrameMemory> logicalMemory;
	private int pageSize;
	private int sizeMemory;

	public MemoryManager(int sizeMemory, int pageSize) {
		this.memory = new SubProcess[sizeMemory][];
		this.pageSize = pageSize;
		logicalMemory = new Hashtable<>();
	}

	

	public void write(Process p) {
		/*if (strategy.equals(strategy.FIRST_FIT)) {
			this.writeUsingFirstFit(p);
		} else if (strategy.equals(strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		} else if (strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWorstFit(p);
		}*/
	}
	
	public void deleteProcess(Process p) {
	    for (int i = 0; i < memory.length; i++) {
	        if (memory[i] != null && memory[i].equals(p.getName())) {
	            memory[i] = null; 
	        }
	    }
	    System.out.println("Processo " + p.getName() + " removido da memória.");
	    printMemoryStatus();
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
					//memory[j] = p.getName();
				}
				System.out.println("------------------------------------------------------");
				printMemoryStatus();
				System.out.println("Memoria atual");
			} else {
				System.out.println("Sem espaço suficiente para alocar o processo: " + p.getName());
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
				//memory[j] = p.getName();
			}
			System.out.println("------------------------------------------------------");
			printMemoryStatus();
			System.out.println("Memoria atual");
		} else {
			System.out.println("Não há espaço suficiente na memória para alocar o processo: " + p.getName());
		}

	}

	private void writeUsingFirstFit(Process p) {
	    int actualSize = 0;
	    boolean spaceFound = false; 

	    for (int i = 0; i < memory.length; i++) {
	        if (memory[i] == null) {
	            actualSize++; 
	            if (actualSize >= p.getSizeInMemory()) { 
	                spaceFound = true; 
	                int start = i - actualSize + 1; 
	                for (int j = start; j < start + p.getSizeInMemory(); j++) {
	                    //memory[j] = p.getName(); 
	                }
	                break;
	            }
	        } else {
	            actualSize = 0; 
	        }
	    }

	    if (!spaceFound) {
	        System.out.println("Não há espaço suficiente na memória para alocar o processo " + p.getName());
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
