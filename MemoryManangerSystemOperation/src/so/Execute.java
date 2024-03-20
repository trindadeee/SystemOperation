package so;

public class Execute {

	public static void main(String[] args) {
		Process p1 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 20, "p1");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p1, 0, "p1");
		
		Process p2 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 30,"p2");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p2, 0, "p2");
		
		Process p3 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 40, "p3");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p3, 0, "p3");
		
		Process p4 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 38, "p4");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p4, 0,"p4");
	
		Process p5 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 20,"p5");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p5, 0, "p5");
		
		
		SystemOperation.systemcall(SystemCallType.DELETE_PROCESS, p3, 0, "p3");
		SystemOperation.systemcall(SystemCallType.DELETE_PROCESS, p1, 0, "p1");
		
		Process p6 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null, 10, "p6");
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p6, 0,"p6");
//		

	}
	
}