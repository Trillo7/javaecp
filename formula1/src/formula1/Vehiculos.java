package formula1;

public abstract class Vehiculos {
	private String nombreVehiculo=null;
	private int posicion=0;
	private int metros=0;
	
	abstract void paint();
	
	abstract void avanza();
}

