package so.schedule;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;

public abstract class ScheduleQueue extends Schedule {

	private PriorityQueue<Process> queue;
	private Hashtable<String, List<SubProcess>> subProcess;

	public ScheduleQueue(Comparator<Process> comparator) {
		this.queue = new PriorityQueue<>(comparator);
	}

	private void registerSubProcess() {
		Process p = this.queue.peek();
		List<SubProcess> sps = this.subProcess.get(p.getId());
		Core[] cores = this.getCm().getCores();
		
		for(Core core : cores) {
			if(core.getCurrentSubprocess() != null) {
				SubProcess sp = sps.get(0);
				this.getCm().registerProcess(core.getId(), sp);
			}
		}
	}
	
	@Override
	public void execute(Process p) {
		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.READ_PROCESS, p);
		this.queue.add(p);
		this.subProcess.put(p.getId(), sps);
		this.registerSubProcess();
	}

	@Override
	public void finish(Process p) {
		
	}

	public PriorityQueue<Process> getQueue() {
		return queue;
	}
}
