package so.memory;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import so.Process;
import so.SubProcess;

public class MemoryManager {

	private SubProcess[][] memory;
	private Hashtable<String, FrameMemory> logicalMemory;
	private int pageSize;
	private int sizeMemory;
	public static int numberInstrictionsSubProcess = 7;

	public MemoryManager(int sizeMemory, int pageSize) {
		this.pageSize = pageSize;
		this.sizeMemory = sizeMemory;
		int pages = (int) Math.ceil(this.sizeMemory / this.pageSize);
		this.memory = new SubProcess[pages][pageSize];
		this.logicalMemory = new Hashtable<>();
	}

	public void write(Process p) {
		this.writeUsingPaging(p);
	}

	private void writeUsingPaging(Process p) {
		List<FrameMemory> frames = this.getFrames(p);
		if (frames != null) {
			for (int i = 0; i < frames.size(); i++) {
				for (int offSet = 0; offSet < this.pageSize; offSet++) {
					FrameMemory frame = frames.get(i);
					SubProcess sp = new SubProcess(p.getId(), numberInstrictionsSubProcess);
					this.memory[frame.getFrameNumber()][offSet] = sp;
					frame.setOffSet(offSet);
					this.logicalMemory.put(sp.getId(), frame);
				}
			}
		} else {

		}
		//zerando contador
		SubProcess.resetCount();
		this.printMemoryStatus();
	}

	private List<FrameMemory> getFrames(Process p) {
		List<FrameMemory> frames = new LinkedList<>();
		int numOfPages = (int) Math.ceil(p.getSizeInMemory() / this.pageSize);
		for (int frame = 0; frame < this.memory.length; frame++) {
			if (this.memory[frame][0] == null) {
				frames.add(new FrameMemory(frame));
				if (frames.size() == numOfPages) {
					return frames;
				}
			}
		}
		return null;
	}

	private void printMemoryStatus() {
		for (int i = 0; i < this.memory.length; i++) {
			for (int j = 0; j < this.pageSize; j++) {
				SubProcess sp = this.memory[i][j];
				String spId = null;
				if (sp != null) {
					spId = sp.getId();
				}
				if (j == this.memory[i].length - 1) {
					System.out.println(spId);
				} else {
					System.out.println(spId + " | ");
				}
			}
		}
	}


	public void deleteProcess(Process p) {
		for (int i = 0; i < memory.length; i++) {
			if (memory[i] != null && memory[i].equals(p.getId())) {
				memory[i] = null;
			}
		}
		System.out.println("Processo " + p.getId() + " removido da memória.");
		printMemoryStatus();
	}

	public List<SubProcess> read(Process p){
		List<String> ids = p.getprocess();
		List<SubProcess> sps = new LinkedList<>();
		for(String id : ids) {
			FrameMemory fm = this.logicalMemory.get(id);
			sps.add(this.memory[fm.getFrameNumber()][fm.getOffSet()]);
		}
		return sps;
	}
	
	
	
	
	
	
	
	// codigo antigo implementando worst, best e first o zé colinha pode pegar o
	// código sem direitos autorais
//	private void writeUsingWorstFit(Process p) {
//		int maxSize = -1;
//		int start = -1;
//		int i = 0;
//
//		while (true) {
//			int j;
//			while (i < memory.length) {
//				if (memory[i] == null) {
//					for (j = i; j < memory.length && memory[j] == null; ++j) {
//					}
//
//					int blockSize = j - i;
//					if (blockSize >= p.getSizeInMemory() && blockSize > maxSize) {
//						maxSize = blockSize;
//						start = i;
//					}
//
//					i = j;
//				} else {
//					++i;
//				}
//			}
//
//			if (start != -1) {
//				i = start + p.getSizeInMemory() - 1;
//
//				for (j = start; j <= i; ++j) {
//					// memory[j] = p.getName();
//				}
//				System.out.println("------------------------------------------------------");
//				printMemoryStatus();
//				System.out.println("Memoria atual");
//			} else {
//				System.out.println("Sem espaço suficiente para alocar o processo: " + p.getId());
//			}
//
//			return;
//		}
//	}
//
//	private void writeUsingBestFit(Process p) {
//		int minSize = Integer.MAX_VALUE;
//		int start = -1;
//
//		for (int i = 0; i < memory.length;) {
//			if (memory[i] == null) {
//				int j = i;
//				while (j < memory.length && memory[j] == null) {
//					j++;
//				}
//				int blockSize = j - i;
//				if (blockSize >= p.getSizeInMemory() && blockSize < minSize) {
//					minSize = blockSize;
//					start = i;
//				}
//				i = j + 1;
//			} else {
//				i++;
//			}
//		}
//
//		if (start != -1) {
//			int end = start + p.getSizeInMemory() - 1;
//			for (int j = start; j <= end; j++) {
//				// memory[j] = p.getName();
//			}
//			System.out.println("------------------------------------------------------");
//			printMemoryStatus();
//			System.out.println("Memoria atual");
//		} else {
//			System.out.println("Não há espaço suficiente na memória para alocar o processo: " + p.getId());
//		}
//
//	}
//
//	private void writeUsingFirstFit(Process p) {
//		int actualSize = 0;
//		boolean spaceFound = false;
//
//		for (int i = 0; i < memory.length; i++) {
//			if (memory[i] == null) {
//				actualSize++;
//				if (actualSize >= p.getSizeInMemory()) {
//					spaceFound = true;
//					int start = i - actualSize + 1;
//					for (int j = start; j < start + p.getSizeInMemory(); j++) {
//						// memory[j] = p.getName();
//					}
//					break;
//				}
//			} else {
//				actualSize = 0;
//			}
//		}
//
//		if (!spaceFound) {
//			System.out.println("Não há espaço suficiente na memória para alocar o processo " + p.getId());
//		}
//
//		System.out.println("------------------------------------------------------");
//		printMemoryStatus();
//		System.out.println("Memoria atual");
//	}

}
