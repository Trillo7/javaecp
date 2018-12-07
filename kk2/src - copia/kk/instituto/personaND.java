package kk.instituto;

public class personaND extends persona {
	
	private String descripcion;

	public personaND() {
		super();
		// TODO Auto-generated constructor stub
	}

	public personaND(String nombre, String apellidos, String fechaNaci,String descripcion) {
		super(nombre, apellidos, fechaNaci);
		this.descripcion = descripcion;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "personaND [getDescripcion()=" + getDescripcion() + ", getNombre()=" + getNombre() + ", getApellidos()="
				+ getApellidos() + ", getFechaNaci()=" + getFechaNaci() + "]";
	}
	
	
	
	
}
