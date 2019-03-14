package examenFeb;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;


public class Caja {
	static float totalpago;
	public static HashMap<String,Articulo> hmcaja=new HashMap<String, Articulo>();
	public static List<Articulo> listaeliminar=new ArrayList<Articulo>();
	private static List<DevolverListener> ListenersDevolver=new ArrayList<DevolverListener>();
	
	public static void addDevolverArticulo (DevolverListener listener) {
		ListenersDevolver.add(listener);
	}
	
	public static void removeDigitoEncontradoListener (DevolverListener listener) {
		ListenersDevolver.remove(listener);
	}
	
	public static void fireDigitoEncontradoListener (DevolverEvent evento) {
		for (DevolverListener listener : ListenersDevolver) {
			listener.DevolverArticulo(evento);
		}
	}
	
	/**
	 * @param hmcaja
	 */
	public Caja(HashMap<String, Articulo> hmcaja) {
		super();
		this.hmcaja = hmcaja;
	}
	
	public static void pasaracaja(List<Articulo> carroCliente) {
		Iterator<Articulo> productosCli = carroCliente.iterator();
		
		while(productosCli.hasNext()) {
			Articulo producto=productosCli.next();
			float precio=producto.precio*producto.cantidad;
			totalpago+=precio;
			System.out.println("*Beep* "+producto.cantidad+" x "+producto.nombre+" - "+producto.getDescripcion());
			hmcaja.put(producto.nombre, producto);
		}		
		
		
	}
	
	public static void preguntaCliente() {
		Iterator<Articulo> encaja=hmcaja.values().iterator();
		while(encaja.hasNext()) {
			Articulo producto=encaja.next();
			int devuelve=JOptionPane.showConfirmDialog(null, "Quieres devolver: "+producto.nombre);
			if(devuelve==0) {
				Date fechactual=new Date();
				producto.fechaDated=producto.formatDated.format(fechactual);
				float precio=producto.precio*producto.cantidad;
				listaeliminar.add(producto);
				totalpago-=precio;
			}
		}
		// Eliminamos a devolver
		for(int i=0;i<listaeliminar.size();i++) {
			DevolverEvent evento=new DevolverEvent(listaeliminar.get(i));
			fireDigitoEncontradoListener(evento);
			hmcaja.remove(listaeliminar.get(i).nombre);
		}
		System.out.println("Total: "+totalpago);
	}
	
	public static void pagar() throws CashInsuficienteException{
		float dineroCliente=Float.parseFloat(JOptionPane.showInputDialog("Introduce el dinero en efectivo (Euros): "));
		if(dineroCliente<totalpago) {
			throw new CashInsuficienteException("No tienes suficiente dinero");
		}
	}
}
