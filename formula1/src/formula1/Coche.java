package formula1;

import java.awt.Color;
import java.awt.Graphics;

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
	public Coche(int id, String nombreVehiculo, int posicion, int mialtura, int metros, int meta) {
		super(id,nombreVehiculo, posicion, mialtura, metros, meta);
		// TODO Auto-generated constructor stub
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

	@Override
	void paint() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.fillRect(this.getPosicion()+17, this.getMialtura()-25, 60, 25);//cabina
		g.fillRect(this.getPosicion(), this.getMialtura(), 90, 35);//chasis
	    g.fillOval(this.getPosicion()+10, this.getMialtura()+25,20,20);//ruedas
	    g.fillOval(this.getPosicion()+50, this.getMialtura()+25,20,20);//ruedas
	    
	    
	}
	
}
