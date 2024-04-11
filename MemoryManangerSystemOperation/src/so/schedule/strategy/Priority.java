package so.schedule.strategy;

import java.util.Comparator;

import so.Process;
import so.SubProcess;
import so.schedule.ScheduleQueue;

public class Priority extends ScheduleQueue{

	public Priority() {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process p1, Process p2) {
				
				return p1.getPriority().getNivel() > p2.getPriority().getNivel() ? 1 : -1;
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
