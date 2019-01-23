package kk.capitulo5.bloque5.Colab5ej2;

public class Supermercado {
	private static int colas=1;
	
	public static void crearSuper() {
		Cola cola1=new Cola(1);
		//Añadimos algunos clientes
		Cliente cliente1=new Cliente(1,"Pepito");
		Cliente cliente2=new Cliente(2,"Manolito");
		Cliente cliente3=new Cliente(3,"Carmen");
		Cliente cliente4=new Cliente(4,"Antonio");
		Cliente cliente5=new Cliente(5,"Maria");
		Cliente cliente6=new Cliente(6,"Alba");
		Cliente cliente7=new Cliente(7,"Jesus");

		cola1.agregarCliente(cliente1);
		cola1.agregarCliente(cliente2);
		cola1.agregarCliente(cliente3);
		cola1.agregarCliente(cliente4);
		cola1.agregarCliente(cliente5);
		cola1.agregarCliente(cliente6);
		cola1.agregarCliente(cliente7);
		cola1.imprime();
		Cola cola2=new Cola(2);
		cola2=cola1.dividirCola();
		cola1.imprime();
		System.out.println("Cola 2");
		cola2.imprime();
		
		

	}

	/**
	 * @return the colas
	 */
	public static int getColas() {
		return colas;
	}

	/**
	 * @param colas the colas to set
	 */
	public static void setColas(int colas) {
		Supermercado.colas = colas;
	}
	
}
