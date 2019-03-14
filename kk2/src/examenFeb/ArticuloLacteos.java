package examenFeb;

public class ArticuloLacteos extends Articulo {
	
	boolean sinlactosa; // Articulo lacteo pero si true puede ser apto para tolerantes a la lactosa

	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 * @param sinlactosa
	 */
	public ArticuloLacteos(int id, String nombre, int cantidad, float precio, boolean sinlactosa) {
		super(id, nombre, cantidad, precio);
		this.sinlactosa = sinlactosa;
		this.descripcion="Articulo seccion lacteos";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}
	
	

}
