package formula1;

import java.awt.Color;
import java.awt.Graphics;

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
	public Moto(int id,String nombreVehiculo, int posicion, int mialtura, int metros, int meta) {
		super(id, nombreVehiculo, posicion, mialtura,metros, meta);
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
	void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillOval(this.getPosicion()+33, this.getMialtura()-10, 10, 25);//cabina
		g.fillRect(this.getPosicion(), this.getMialtura()+10, 70, 15);//chasis
		//g.fillRect(this.getPosicion(), this.getMialtura()+10, 5, 25);//guardabarros
		g.fillRect(this.getPosicion()+35, this.getMialtura()+10, 10, 25);//pierna
	    g.fillOval(this.getPosicion()+10, this.getMialtura()+25,20,20);//ruedas
	    g.fillOval(this.getPosicion()+50, this.getMialtura()+25,20,20);//ruedas
	}

}
