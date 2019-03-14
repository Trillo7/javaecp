package examenFeb;

public class ArticuloJuguete extends Articulo {
	boolean aptobebes;

	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 * @param aptobebes
	 */
	public ArticuloJuguete(int id, String nombre, int cantidad, float precio, boolean aptobebes) {
		super(id, nombre, cantidad, precio);
		this.aptobebes = aptobebes;
		this.descripcion="Producto de seccion juguetes";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}
	
}
