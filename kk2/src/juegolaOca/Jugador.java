package juegolaOca;

public class Jugador {
	private String nombre;
	private int posicion;
	
	/**
	 * 
	 */
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nombre
	 * @param posicion
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.posicion=1;
	}
	
	public void tirarDado () {
		int dado = (int) Math.round(Math.random()*(6-1)+1);
		this.posicion += dado;
		int indiceCasillaMeta=Tablero.getTablero().getCasillas().length-1;
		if (this.posicion > indiceCasillaMeta) {
			this.posicion = indiceCasillaMeta - 
					(this.posicion - indiceCasillaMeta);
		}
		// Comprobamos si es una casilla con destino
		if(Tablero.getTablero().getCasillas()[posicion].getDestino()!=null) {
			// Comprobamos rebote de nuevo NO FUNCIONAAAAA
		
			Casilla casillaDestino = Tablero.getTablero().getCasillas()[this.posicion].getDestino();
			this.posicion=casillaDestino.getOrden()-1;
			System.out.println(casillaDestino.getMensajeEspecial());
		}
		
	}
	
	public void imprimir() {
		System.out.println("Jugador: "+this.nombre + " - pos: " + (this.posicion+1));
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
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	
}
