package examenFeb;

import java.util.ArrayList;
import java.util.List;

public class Mainmercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArticuloAlcohol bebida1=new ArticuloAlcohol(1, "Vodka", 2, (float) 3.80, true);
		ArticuloJuguete juguete1=new ArticuloJuguete(2, "Hot wheels", 1, (float) 16.10, false);
		ArticuloLacteos lacteo1=new ArticuloLacteos(3, "Leche con calcio", 2, (float) 1.40, false);
		ArticuloLimpiezaYHogar lejia1=new ArticuloLimpiezaYHogar(4, "Lejia B", 1, (float) 5.42, true);
		ArticuloProductoFresco pescado1=new ArticuloProductoFresco(5, "Salmon", 4, (float) 9.76, true);
		List<Articulo> carroPepito=new ArrayList<Articulo>();
		carroPepito.add(bebida1);
		carroPepito.add(juguete1);
		carroPepito.add(lacteo1);
		carroPepito.add(lejia1);
		carroPepito.add(pescado1);
		Cliente pepito=new Cliente("Pepito", carroPepito);
		Caja.addDevolverArticulo(new SupervisorCaja());
		Caja.pasaracaja(pepito.carro);
		Caja.preguntaCliente();
		try {
			Caja.pagar();
		} catch (CashInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
