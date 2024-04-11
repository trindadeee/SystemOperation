package so;

import java.util.List;
import java.util.Objects;

import so.memory.MemoryManager;
import so.schedule.Schedule;
import so.schedule.strategy.FCFS;
import so.schedule.strategy.SJF;

public class SystemOperation {

	public static MemoryManager mm;
	
	public static Schedule schedule;

	public static Process systemCall(SystemCallType type, int sizeInMemory) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (Objects.isNull(mm)) {
				mm = new MemoryManager(256, 4);
			}
			if (Objects.isNull(schedule)) {
				schedule = new FCFS();
			}

		}
		return new Process(sizeInMemory);
	}

	public static List<SubProcess> systemCall(SystemCallType type, Process p) {
		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
			schedule.execute(p);

		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			mm.read(p);

			//mudança do delete_process para o close_process
		} else if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			mm.deleteProcess(p);
			schedule.finish(p);
		}
		return null;
	}
}
