package kk.instituto;

public class fp extends matricula {
	private boolean dual;

	public fp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public fp(String fecha, int codigomatri,boolean dual) {
		super(fecha, codigomatri);
		this.dual = dual;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the dual
	 */
	public boolean isDual() {
		return dual;
	}

	/**
	 * @param dual the dual to set
	 */
	public void setDual(boolean dual) {
		this.dual = dual;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "fp [dual=" + dual + ", getFecha()=" + getFecha() + ", getCodigomatri()=" + getCodigomatri() + "]";
	}

	
	
	
	

	
	
	
}
