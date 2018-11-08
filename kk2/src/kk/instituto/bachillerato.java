package kk.instituto;

public class bachillerato extends matricula {
	private String modalidad;

	public bachillerato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bachillerato(String fecha, int codigomatri, String modalidad) {
		super(fecha, codigomatri);
		this.modalidad = modalidad;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the modalidad
	 */
	public String getModalidad() {
		return modalidad;
	}

	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "bachillerato [modalidad=" + modalidad + ", getFecha()=" + getFecha() + ", getCodigomatri()="
				+ getCodigomatri() + "]";
	}

	
	
	
}
