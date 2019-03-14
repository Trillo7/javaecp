package examenFeb;

public class ArticuloAlcohol extends Articulo {
	boolean destilado;
	
	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 * @param destilado
	 */
	public ArticuloAlcohol(int id, String nombre, int cantidad, float precio, boolean destilado) {
		super(id, nombre, cantidad, precio);
		this.destilado = destilado;
		this.descripcion="Bebidas alcoholicas";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}
	
}
