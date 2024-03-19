package so;

public class Execute {

	public static void main(String[] args) {
		Process p1 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 2);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p1, 0);
		
		Process p2 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 4);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p2, 0);
		
		Process p3 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 5);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p3, 0);
		
//		Process p4 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 2);
//		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p4, 0);
//		
		Process p5 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 3);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p5, 0);
		
		
		SystemOperation.systemcall(SystemCallType.DELETE_PROCESS, p3, 0);
		SystemOperation.systemcall(SystemCallType.DELETE_PROCESS, p1, 0);
		
		Process p6 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 1);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p6, 0);
		
	}
	
}