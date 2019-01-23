package kk.capitulo5.bloque5.Colab5ej2;

import java.util.ArrayList;
import java.util.List;

public class Cola {
	private int IDCola;
	private List<Cliente> clientes=new ArrayList<Cliente>();
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

	public Cola dividirCola() {
		System.out.println("Separamos la cola");
		Supermercado.setColas(Supermercado.getColas()+1);
		Cola cola2=new Cola(2);
		
		for(int i=0;i<=clientes.size()/2;i++) {
			cola2.clientes.add(clientes.get(i));
			clientes.remove(i);
		}
		return cola2;
	}

	public void agregarCliente(Cliente pcliente) {
		clientes.add(pcliente);
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
	
	public void imprime() {
		for(int i=0;i<clientes.size();i++) {
			System.out.print(" "+clientes.get(i).getNombre());
		}
		System.out.println(" ");
	}
	
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
