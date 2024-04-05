	package so.memory;

public class FrameMemory {

	private int frameNumber;
	private int offSet;

	public FrameMemory(int frameNumber, int offSet) {
		this.frameNumber = frameNumber;
		this.offSet = offSet;
	}

	public FrameMemory(int pageNumber) {
		this(pageNumber, 0);
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(int frameNumber) {
		this.frameNumber = frameNumber;
	}

	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

}
