package examenFeb;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Articulo {
	public int id;
	public String nombre;
	public int cantidad;
	public float precio;
	public String descripcion;
	SimpleDateFormat formatDated=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String fechaDated;
	
	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 * @param descripcion
	 */
	public Articulo(int id, String nombre, int cantidad, float precio, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Articulo(int id, String nombre, int cantidad, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * @return the descripcion
	 */
	public abstract String getDescripcion();
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
