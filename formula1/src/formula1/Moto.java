package formula1;

public class Moto extends Vehiculos {

	
	/**
	 * 
	 */
	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreVehiculo
	 * @param posicion
	 * @param metros
	 */
	public Moto(int id,String nombreVehiculo, int posicion, int metros, int meta) {
		super(id, nombreVehiculo, posicion, metros, meta);
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
		return "Moto [getNombreVehiculo()=" + getNombreVehiculo() + ", getPosicion()=" + getPosicion()
				+ ", getMetros()=" + getMetros() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
