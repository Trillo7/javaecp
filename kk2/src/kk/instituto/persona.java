package kk.instituto;

public class persona {
	private String nombre;
	private String apellidos;
	private String fechaNaci;
	
	public persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public persona(String nombre, String apellidos, String fechaNaci) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNaci = fechaNaci;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the fechaNaci
	 */
	public String getFechaNaci() {
		return fechaNaci;
	}

	/**
	 * @param fechaNaci the fechaNaci to set
	 */
	public void setFechaNaci(String fechaNaci) {
		this.fechaNaci = fechaNaci;
	}
	
	
	
}
