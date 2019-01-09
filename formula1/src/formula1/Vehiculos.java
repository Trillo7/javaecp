package formula1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Vehiculos {
	private String nombreVehiculo=null;
	private int posicion=0;
	private int mialtura=0;
	private int id=0;
	private int metros=0;
	private int meta;
	private Color color=null;
	
	
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
	public Vehiculos(int id,String nombreVehiculo, int posicion,int mialtura, int metros, int meta) {
		super();
		this.id=id;
		this.nombreVehiculo = nombreVehiculo;
		this.posicion = posicion;
		this.mialtura = mialtura;
		this.metros = metros;
		this.meta = meta;
	}

	abstract void paint();
	
	public void avanza() {
		this.setMetros((int) Math.round(Math.random() * ((50) - 3) + 3));
		this.setPosicion(this.getMetros()+this.getPosicion()); 
		
		// Meta para que termine el juego y tambien lo usamos para el podium
		if(this.posicion>=Juego.getInstance().getLongitudCarrera() && this.meta!=1) {
			this.meta=1;
			if(Juego.getInstance().getPodium()[0]==null) {
				Juego.getInstance().getPodium()[0]=this.getId();
			}else if(Juego.getInstance().getPodium()[1]==null) {
				Juego.getInstance().getPodium()[1]=this.getId();
			}else if(Juego.getInstance().getPodium()[2]==null) {
				Juego.getInstance().getPodium()[2]=this.getId();

			}
		}

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMialtura() {
		return mialtura;
	}

	public void setMialtura(int mialtura) {
		this.mialtura = mialtura;
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

	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getMeta() {
		return meta;
	}

	public void setMeta(int meta) {
		this.meta = meta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculos [nombreVehiculo=" + nombreVehiculo + ", posicion=" + posicion + ", metros=" + metros + "]";
	}

	void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
}

