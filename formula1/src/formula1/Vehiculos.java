package formula1;

public abstract class Vehiculos {
	private String nombreVehiculo=null;
	private int posicion=0;
	private int metros=0;
	
	
	
	/**
	 * 
	 */
	public Vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreVehiculo
	 * @param posicion
	 * @param metros
	 */
	public Vehiculos(String nombreVehiculo, int posicion, int metros) {
		super();
		this.nombreVehiculo = nombreVehiculo;
		this.posicion = posicion;
		this.metros = metros;
	}

	abstract void paint();
	
	public void avanza() {
		this.setMetros(this.getMetros()+(int) Math.round(Math.random() * ((50) - 3) + 3));;

	}

	/**
	 * @return the nombreVehiculo
	 */
	public String getNombreVehiculo() {
		return nombreVehiculo;
	}

	/**
	 * @param nombreVehiculo the nombreVehiculo to set
	 */
	public void setNombreVehiculo(String nombreVehiculo) {
		this.nombreVehiculo = nombreVehiculo;
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

	/**
	 * @return the metros
	 */
	public int getMetros() {
		return metros;
	}

	/**
	 * @param metros the metros to set
	 */
	public void setMetros(int metros) {
		this.metros = metros;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculos [nombreVehiculo=" + nombreVehiculo + ", posicion=" + posicion + ", metros=" + metros + "]";
	}
	
	
}

