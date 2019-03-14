package examenFeb;

public class DevolverEvent {
	Articulo articulo;

	/**
	 * @param articulo
	 */
	public DevolverEvent(Articulo articulo) {
		super();
		this.articulo = articulo;
	}

	/**
	 * @return the articulo
	 */
	public Articulo getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
}
