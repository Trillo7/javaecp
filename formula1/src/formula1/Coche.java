package formula1;

public class Coche extends Vehiculos {

	/**
	 * 
	 */
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreVehiculo
	 * @param posicion
	 * @param metros
	 */
	public Coche(String nombreVehiculo, int posicion, int metros) {
		super(nombreVehiculo, posicion, metros);
		// TODO Auto-generated constructor stub
	}

	@Override
	void paint() {
		// TODO Auto-generated method stub

	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coche [getNombreVehiculo()=" + getNombreVehiculo() + ", getPosicion()=" + getPosicion()
				+ ", getMetros()=" + getMetros() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	
}
