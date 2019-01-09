package formula1;

import javax.swing.JOptionPane;

public class Juego {
	private static Vehiculos vehiculos[] = new Vehiculos[5];
	public static Pista pistas[]=new Pista[vehiculos.length];
	private static Juego juego=null;
	private static int LongitudCarrera=800;
	private static Integer[] podium=new Integer[3];

	public void cargaJuego() {
		// TODO Auto-generated method stub
		//Generamos los vehiculos
		vehiculos[0]= new Coche(0,"Stroper 200",0,70,0,0);
		vehiculos[1]= new Moto(1,"Kingle 3000",0,250,0,0);
		vehiculos[2]= new Coche(2,"Harfkel 7",0,430,0,0);
		vehiculos[3]= new Moto(3,"Vonhelkiem I",0,610,0,0);
		vehiculos[4]= new Coche(4,"Propulsion 900",0,790,0,0);
	
		
		//Inicializamos las pistas
		for(int i=0;i <vehiculos.length;i++) {
			pistas[i]=new Pista(vehiculos[i]);
			
		}	
		
		//Sistema de turnos
		do {
			for(int i=0;i<vehiculos.length;i++) {
				vehiculos[i].avanza();
				for(int h=0;h<4;h++) {
					if(vehiculos[i].getPosicion()>=pistas[i].getObstaculos()[h].getPosicion()&& pistas[i].getObstaculos()[h].getPisado()==0) {
						System.out.println("pisa obstaculo");
						pistas[i].getObstaculos()[h].setPisado(1);
					}
				}
				Ventana.getVentana().repaint();
				System.out.println(pistas[i].toString());
				JOptionPane.showMessageDialog(null, "Siguiente jugada");
			}
			
		}while(!isTerminado());
		// Juego acabado. Mostramos podium
		System.out.println("1 Posicion: "+this.getPodium()[0]+vehiculos[this.getPodium()[0]].getNombreVehiculo());
		System.out.println("2 Posicion: "+this.getPodium()[1]+vehiculos[this.getPodium()[1]].getNombreVehiculo());
		System.out.println("3 Posicion: "+this.getPodium()[2]+vehiculos[this.getPodium()[2]].getNombreVehiculo());

	}

	
	
	public boolean isTerminado(){
		for(int i=0;i<vehiculos.length;i++) {
			if(vehiculos[i].getMeta()==0) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static Vehiculos[] getVehiculos() {
		return vehiculos;
	}



	public static void setVehiculos(Vehiculos[] vehiculos) {
		Juego.vehiculos = vehiculos;
	}



	public static int getLongitudCarrera() {
		return LongitudCarrera;
	}

	public static void setLongitudCarrera(int longitudCarrera) {
		LongitudCarrera = longitudCarrera;
	}

	//Singleton de juego
	public static Juego getInstance(){
		if (juego == null) {
			juego = new Juego();
		}
		return juego;
		
	}



	public static Integer[] getPodium() {
		return podium;
	}



	public static void setPodium(Integer[] podium) {
		Juego.podium = podium;
	}
}
