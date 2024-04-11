package so;

public class Execute {

	public static void main(String[] args) {
		Process p1 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 50);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		
		Process p2 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 22);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
		
		Process p3 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 25);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
		
//		Process p4 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 28);
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p4);
//	
//		Process p5 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS, 2);
//		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p5);
		


	}
	
}