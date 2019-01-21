package kk.capitulo5.bloque5.Colab5ej2;

import java.util.ArrayList;
import java.util.List;

public class Cola {
	private int IDCola;
	private List<Cliente> clientes0=new ArrayList<Cliente>();
	private static Cola cola=null;
	private int alterna=0;
	
	/**
	 * 
	 */
	public Cola() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param iDCola
	 * @param clientes
	 */
	public Cola(int iDCola) {
		super();
		IDCola = iDCola;
	}


	public void agregarCliente(Cliente pcliente, int colas) {
		if(colas>1) {
			
			
			//Para ir poniendolos en una cola u otra equitativamente
			if(alterna==0) {alterna=1;}else {alterna=0;}
		}else {
			clientes0.add(pcliente);
		}
		
	}


	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	};
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cola [IDCola=" + IDCola + ", clientes=" + clientes + "]";
	}

	// Single-ton de Cola
	public static Cola Instance() {
		if (cola == null) {
			cola = new Cola();
		}
		return cola;
	}
}
