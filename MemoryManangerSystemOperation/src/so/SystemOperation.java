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

	public static Process systemCall(SystemCallType type, int sizeInMemory) {
		if (type.equals(SystemCallType.CREATE_PROCESS)) {
			if (Objects.isNull(mm)) {
				mm = new MemoryManager(256, 4);
			}
			if (Objects.isNull(cm)) {
				cm = new CpuManager();
			}

		}
		return new Process(sizeInMemory);
	}

	public static void systemCall(SystemCallType type, Process p) {
		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);

		} else if (type.equals(SystemCallType.READ_PROCESS)) {

		} else if (type.equals(SystemCallType.DELETE_PROCESS)) {
			mm.deleteProcess(p);
		}
	}
}
