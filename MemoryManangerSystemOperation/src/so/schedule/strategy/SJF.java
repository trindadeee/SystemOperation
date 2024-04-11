package so.schedule.strategy;

import java.util.Comparator;

import so.Process;
import so.SubProcess;
import so.schedule.ScheduleQueue;

public class SJF extends ScheduleQueue{

	public SJF() {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process sp1, Process sp2) {
				return sp1.getTimeToExecute() <= sp2.getTimeToExecute() ? 1 : -1;
			}
		});
	}

	@Override
	public void execute(Process p) {
		
	}

	@Override
	public void finish(Process p) {
		
	}

}
