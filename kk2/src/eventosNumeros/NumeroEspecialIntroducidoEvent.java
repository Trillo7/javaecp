package eventosNumeros;

public class NumeroEspecialIntroducidoEvent {
	
	private int numeroIntroducido;

	/**
	 * @param numeroIntroducido
	 */
	public NumeroEspecialIntroducidoEvent(int numeroIntroducido) {
		super();
		this.numeroIntroducido = numeroIntroducido;
	}

	/**
	 * 
	 * @return
	 */
	public int getNumeroIntroducido() {
		return numeroIntroducido;
	}

	/**
	 * 
	 * @param numeroIntroducido
	 */
	public void setNumeroIntroducido(int numeroIntroducido) {
		this.numeroIntroducido = numeroIntroducido;
	}
	
	
}
