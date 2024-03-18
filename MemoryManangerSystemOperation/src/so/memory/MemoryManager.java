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
		this.memory = new String[128];
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
			this.writeUsingWirstFit(p);
		}else if (strategy.equals(strategy.PAGING)) {
			this.writeUsingPaging(p);
		}
	}
	private void delete(Process p) {
		List<FrameMemory> frames = this.logicalMemory.get(p.getId());
		for (int i = 0; i < frames.size(); i++) {
			FrameMemory actuallyFrame = frames.get(i);
			for(int j = actuallyFrame.getFrameNumber(); j < actuallyFrame.getOffset(); j++) {
				this.memory[j] = null;
				
			}
		}
		this.logicalMemory.remove(p.getId());
	}
	
	private void writeUsingPaging(Process p) {
		List<FrameMemory> frames = this.getFrames(p);
		if (frames == null) {
			System.out.println("Não há espaço sulficiente em memória");
		}else {
			for (int i = 0; i < frames.size(); i++) {
				FrameMemory actuallyFrame = frames.get(i);
				for(int j = actuallyFrame.getFrameNumber(); j < actuallyFrame.getOffset(); j++) {
					this.memory[j] = p.getId();
					
				}
			}
		}
		this.logicalMemory.put(p.getId(), frames);
		printMemoryStatus();
	}
	
	private List<FrameMemory> getFrames(Process p){
		List<FrameMemory> frames = new ArrayList<>();
		int increment = 0;
		for (int page=0; page < this.memory.length; page += pageSize) {
			if(this.memory[page] == null) {
				int offset = page + this.pageSize;
				frames.add(new FrameMemory(page, offset));
				increment += this.pageSize;
				if (increment == p.getSizeInMemory()) {
					return frames;
				}
			}
		}
		return null;
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
