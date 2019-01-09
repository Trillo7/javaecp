package formula1;
import java.io.*;
import sun.audio.*;

import java.awt.Color;

import javax.swing.JOptionPane;

public class Juego {
	private static Vehiculos vehiculos[] = new Vehiculos[5];
	public static Pista pistas[]=new Pista[vehiculos.length];
	private static Juego juego=null;
	private static int LongitudCarrera=720;
	private static Integer[] podium=new Integer[3];

	public void cargaJuego() throws Exception {
		// TODO Auto-generated method stub
		//Generamos los vehiculos
		vehiculos[0]= new Coche(0,"Stroper 200",0,70,0,0);
		vehiculos[1]= new Moto(1,"Kingle 3000",0,250,0,0);
		vehiculos[2]= new Coche(2,"Harfkel 7",0,430,0,0);
		vehiculos[3]= new Moto(3,"Vonhelkiem I",0,610,0,0);
		vehiculos[4]= new Coche(4,"Propulsion 900",0,790,0,0);
		
		//Color aleatorio para cada vehiculo
		int[] numcolores = new int[5];
		for(int i=0;i<5;i++) {
			boolean flag=false;
			int x=0;
			int numalea=(int) Math.round(Math.random() * ((5) - 0) + 0);
			for(x=0;x<5;x++) {
				if(numalea==numcolores[x]) {
					flag=true;
				}// si alguna vez se activa la bandera vuelve a generar um numero
			}
			numcolores[i]=numalea;
			if (flag==true) {i--;}
		}
		//Depende del numero instroducimos un color u otro
		for(int x=0;x<5;x++){
			Color coloractual = null;
			System.out.println(numcolores[x]);
	        switch (numcolores[x]) {
	            case 1:  coloractual = Color.black;
	                     break;
	            case 2:  coloractual = Color.BLUE;
	                     break;
	            case 3: coloractual = Color.RED;
	                     break;
	            case 4:  coloractual = Color.YELLOW;
	                     break;
	            case 5:  coloractual = Color.GREEN;
	                     break;
	            default: coloractual = Color.pink;
	                     break;
	        }
			Juego.getInstance().getVehiculos()[x].setColor(coloractual);
		}
		
		//Inicializamos las pistas
		for(int i=0;i <vehiculos.length;i++) {
			pistas[i]=new Pista(vehiculos[i]);
			
		}	
		
		//Sistema de turnos
		do {
			for(int i=0;i<vehiculos.length;i++) {
				Ventana.getVentana().repaint();

				JOptionPane.showMessageDialog(null, "Siguiente jugada");
				vehiculos[i].avanza();// Avanzamos y luego ajustamos la posicion si pisa algun obstaculo
				for(int h=0;h<4;h++) {
					if(vehiculos[i].getPosicion()>=pistas[i].getObstaculos()[h].getPosicion()&& pistas[i].getObstaculos()[h].getPisado()==0) {
						System.out.println("pisa obstaculo");
						pistas[i].getObstaculos()[h].setPisado(1);
						vehiculos[i].setPosicion(vehiculos[i].getPosicion()+pistas[i].getObstaculos()[h].getAccion());
						
						// REPRODUCIMOS SONIDO SEGUN PISEMOS
						if(pistas[i].getObstaculos()[h] instanceof Rampa) {
							 // open the sound file as a Java input stream
						    String gongFile = "/Users/frtri/git/javaecpf1/formula1/src/formula1/assets/rampa.au";
						    InputStream in = new FileInputStream(gongFile);

						    // create an audiostream from the inputstream
						    AudioStream audioStream = new AudioStream(in);

						    // play the audio clip with the audioplayer class
						    AudioPlayer.player.start(audioStream);
						}else {
							 // open the sound file as a Java input stream
						    String gongFile = "/Users/frtri/git/javaecpf1/formula1/src/formula1/assets/mancha.au";
						    InputStream in = new FileInputStream(gongFile);

						    // create an audiostream from the inputstream
						    AudioStream audioStream = new AudioStream(in);

						    // play the audio clip with the audioplayer class
						    AudioPlayer.player.start(audioStream);
						}
					}
				}
				System.out.println(pistas[i].toString());
			}
			
		}while(!isTerminado());
		Ventana.getVentana().jframe.setVisible(false);
		VentanaPodium.getVentana().repaint();


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
