package kk.capitulo5.bloque5.Colab5ej2;

public class Cliente {
	private int ID;
	private String nombre;

	
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param iD
	 * @param nombre
	 */
	public Cliente(int iD, String nombre) {
		super();
		ID = iD;
		this.nombre = nombre;
	}

	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}


	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
