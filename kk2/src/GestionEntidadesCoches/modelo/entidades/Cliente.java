package GestionEntidadesCoches.modelo.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private int id;
	private String nombre;
	private String apellidos;
	private String localidad;
	private String dniNie;
	private Date fechaNac;
	private boolean activo;
	
	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param localidad
	 * @param dniNie
	 * @param fechaNac
	 * @param activo
	 */
	public Cliente(int id, String nombre, String apellidos, String localidad, String dniNie, Date fechaNac,
			boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.localidad = localidad;
		this.dniNie = dniNie;
		this.fechaNac = fechaNac;
		this.activo = activo;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * @return the dniNie
	 */
	public String getDniNie() {
		return dniNie;
	}

	/**
	 * @param dniNie the dniNie to set
	 */
	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	/**
	 * @return the fechaNac
	 */
	public Date getFechaNac() {

		System.out.println(fechaNac);
		
		return fechaNac;
	}

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(Date fechaNac) {
		
		
		this.fechaNac = fechaNac;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
}
