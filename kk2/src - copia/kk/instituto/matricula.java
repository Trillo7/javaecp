package kk.instituto;

public class matricula {
	private String fecha;
	private int codigomatri;
	private String DNI;
	
	public matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public matricula(String fecha, int codigomatri) {
		super();
		this.fecha = fecha;
		this.codigomatri = codigomatri;
	}
	public matricula(String fecha, int codigomatri, String DNI) {
		super();
		this.fecha = fecha;
		this.codigomatri = codigomatri;
		this.DNI = DNI;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the codigomatri
	 */
	public int getCodigomatri() {
		return codigomatri;
	}

	/**
	 * @param codigomatri the codigomatri to set
	 */
	public void setCodigomatri(int codigomatri) {
		this.codigomatri = codigomatri;
	}
	
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	public String getDNI() {
		return DNI;
	}
	
}
