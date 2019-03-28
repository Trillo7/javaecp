package repasoFeb.Bloque8Swing.AdministradorCoches;

public class Coche {
	int id;
	int idFabricante;
	private String bastigador;
	private String nombre;
	private String color;
	/**
	 * @param id
	 * @param idFabricante
	 * @param bastigador
	 * @param nombre
	 * @param color
	 */
	public Coche(int id, int idFabricante, String bastigador, String nombre, String color) {
		super();
		this.id = id;
		this.idFabricante = idFabricante;
		this.bastigador = bastigador;
		this.nombre = nombre;
		this.color = color;
	}
	
	public Coche() {
		super();
		
	}
	
}
