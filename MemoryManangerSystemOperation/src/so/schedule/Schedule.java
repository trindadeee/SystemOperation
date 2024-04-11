package so.schedule;

import so.Process;
import so.cpu.CpuManager;

public abstract class Schedule {

	public CpuManager cm;

	public Schedule() {
		cm = new CpuManager();
	}

	public abstract void execute(Process p);

	public abstract void finish(Process p);

	public CpuManager getCm() {
		return cm;
	}
}
