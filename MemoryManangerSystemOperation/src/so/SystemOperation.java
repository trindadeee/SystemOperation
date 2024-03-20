package so;

import java.util.Objects;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

public class SystemOperation {

	public static MemoryManager mm;
	public static CpuManager cm;
	public static Schedule schedule;

	public static Object systemcall(SystemCallType type, Process p, int sizeInMemory, String name) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (Objects.isNull(mm)) {
				mm = new MemoryManager(Strategy.BEST_FIT);
			}
			if (Objects.isNull(cm)) {
				cm = new CpuManager();
			}

			return new Process(sizeInMemory, name);
		} else if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);

		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			//
		} else if (type.equals(SystemCallType.DELETE_PROCESS)) {
			mm.deleteProcess(p);
		}
		return null;
	}
}
