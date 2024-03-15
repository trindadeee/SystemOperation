package so;

import so.cpu.CpuManager;
import so.maneger.MemoryManager;
import so.schedule.Schedule;

public class SystemOperation {

	public static MemoryManager mm;
	public static CpuManager cm;
	public static Schedule schedule;

	public static Object systemcall(SystemCallType type, Process p) {
		if(type.equals(SystemCallType.CREATE_PROCESS)) {
			//criação do processo
			return new Process();
		}else if(type.equals(SystemCallType.WRITE_PROCESS)){
			//chama o gerenciador de memória
			
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			//
		}else if(type.equals(SystemCallType.DELETE_PROCESS)) {
			//
		}
		return null;
	}
}
