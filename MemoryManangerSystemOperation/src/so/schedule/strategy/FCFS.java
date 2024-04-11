package so.schedule.strategy;

import java.util.Comparator;

import so.Process;
import so.SubProcess;
import so.schedule.ScheduleQueue;

public class FCFS extends ScheduleQueue{

	public FCFS() {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process sp1, Process sp2) {
				return -1;
			}
		});
	}

	@Override
	public void execute(Process p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Process p) {
		// TODO Auto-generated method stub
		
	}

}