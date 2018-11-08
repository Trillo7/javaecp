package kk.instituto;

public class eso extends matricula{
	boolean pmar;

	public eso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public eso(String fecha, int codigomatri, boolean pmar) {
		super(fecha, codigomatri);
		this.pmar = pmar;

	}

	/**
	 * @return the pmar
	 */
	public boolean isPmar() {
		return pmar;
	}

	/**
	 * @param pmar the pmar to set
	 */
	public void setPmar(boolean pmar) {
		this.pmar = pmar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "eso [pmar=" + pmar + ", getFecha()=" + getFecha() + ", getCodigomatri()=" + getCodigomatri() + "]";
	}
	
	
	
	
	
	
	
}
