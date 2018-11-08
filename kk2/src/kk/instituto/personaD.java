package kk.instituto;

public class personaD extends persona {
	
	private String DNI;

	public personaD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public personaD(String nombre, String apellidos, String fechaNaci,String dNI) {
		super(nombre, apellidos, fechaNaci);
		DNI = dNI;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "personaD [getDNI()=" + getDNI() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getFechaNaci()=" + getFechaNaci() + "]";
	}

	
	
	
	
}
