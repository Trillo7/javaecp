package examenMarcianitos;

public abstract class Personajes {
	private String nombre=null;
	private int puntosVida;
	private boolean vivo;
	private int disparosRecibidos=0;
	/**
	 * @param nombre
	 * @param puntosVida
	 * @param vivo
	 * @param disparosRecibidos
	 */
	public Personajes(String nombre, int puntosVida, boolean vivo, int disparosRecibidos) {
		super();
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.vivo = vivo;
		this.disparosRecibidos = disparosRecibidos;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the puntosVida
	 */
	public int getPuntosVida() {
		return puntosVida;
	}
	/**
	 * @param puntosVida the puntosVida to set
	 */
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}
	/**
	 * @return the vivo
	 */
	public boolean isVivo() {
		return vivo;
	}
	/**
	 * @param vivo the vivo to set
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	/**
	 * @return the disparosRecibidos
	 */
	public int getDisparosRecibidos() {
		return disparosRecibidos;
	}
	/**
	 * @param disparosRecibidos the disparosRecibidos to set
	 */
	public void setDisparosRecibidos(int disparosRecibidos) {
		this.disparosRecibidos = disparosRecibidos;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personajes [nombre=" + nombre + ", puntosVida=" + puntosVida + ", vivo=" + vivo + ", disparosRecibidos="
				+ disparosRecibidos + "]";
	}
	
}

