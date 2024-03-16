package so;

public class Execute {

	public static void main(String[] args) {
		Process p1 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p1);
		
		Process p2 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p2);
		
		Process p3 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null);
		SystemOperation.systemcall(SystemCallType.WRITE_PROCESS, p3);
		
		SystemOperation.systemcall(SystemCallType.DELETE_PROCESS, p3);
	}
	
}