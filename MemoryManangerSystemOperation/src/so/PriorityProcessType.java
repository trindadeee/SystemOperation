package so;

public enum PriorityProcessType {

	BAIXA(-1), MEDIA(0), ALTA(1), CRITICA(20000);

	private int nivel;

	PriorityProcessType(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}
}
