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
		Cola.Instance().agregarCliente(cliente1, colas);
		Cola.Instance().agregarCliente(cliente2, colas);
		Cola.Instance().agregarCliente(cliente3, colas);
		Cola.Instance().agregarCliente(cliente4, colas);
		Cola.Instance().agregarCliente(cliente5, colas);
		Cola.Instance().agregarCliente(cliente6, colas);

	}
}
