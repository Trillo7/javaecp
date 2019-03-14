package examenFeb;

public class ArticuloProductoFresco extends Articulo {

	boolean deldia;

	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 * @param deldia
	 */
	public ArticuloProductoFresco(int id, String nombre, int cantidad, float precio, boolean deldia) {
		super(id, nombre, cantidad, precio);
		this.deldia = deldia;
		this.descripcion="Producto seccion frescos";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}
	
}
