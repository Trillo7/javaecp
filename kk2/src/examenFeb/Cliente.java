package examenFeb;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nombrecliente;
	public List<Articulo> carro=new ArrayList<Articulo>();
	/**
	 * @param nombrecliente
	 * @param carro
	 */
	public Cliente(String nombrecliente, List<Articulo> carro) {
		super();
		this.nombrecliente = nombrecliente;
		this.carro = carro;
	}
	
	
}
