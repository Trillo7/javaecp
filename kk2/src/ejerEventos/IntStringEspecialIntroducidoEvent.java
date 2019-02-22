package ejerEventos;

public class IntStringEspecialIntroducidoEvent {
	
	private int numeroIntroducido;
	private String stringIntroducido;

	/**
	 * @param numeroIntroducido
	 */
	public IntStringEspecialIntroducidoEvent(int numeroIntroducido) {
		super();
		this.numeroIntroducido = numeroIntroducido;
	}
	
	public IntStringEspecialIntroducidoEvent(String stringIntroducido) {
		super();
		this.stringIntroducido = stringIntroducido;
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

	/**
	 * @return the stringIntroducido
	 */
	public String getStringIntroducido() {
		return stringIntroducido;
	}

	/**
	 * @param stringIntroducido the stringIntroducido to set
	 */
	public void setStringIntroducido(String stringIntroducido) {
		this.stringIntroducido = stringIntroducido;
	}
	
	
}
