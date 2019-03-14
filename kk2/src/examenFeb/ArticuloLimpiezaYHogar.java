package examenFeb;

public class ArticuloLimpiezaYHogar extends Articulo {
	boolean toxico; 
	
	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 * @param toxico
	 */
	public ArticuloLimpiezaYHogar(int id, String nombre, int cantidad, float precio, boolean toxico) {
		super(id, nombre, cantidad, precio);
		this.toxico = toxico;
		this.descripcion="Producto para la limpieza";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	
}
