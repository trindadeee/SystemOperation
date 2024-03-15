package so;

public class Execute {

	public static void main(String[] args) {
		 Process p1 = (Process)SystemOperation.systemcall(SystemCallType.CREATE_PROCESS, null);
	}
	
}