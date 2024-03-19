package so.memory;

public class FrameMemory {

	private int frameNumber;
	private int offSet;

	public FrameMemory(int frameNumber, int offSet) {
		super();
		this.frameNumber = frameNumber;
		this.offSet = offSet;
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
