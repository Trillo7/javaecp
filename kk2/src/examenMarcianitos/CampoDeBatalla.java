package examenMarcianitos;

import juegoAhorcado.baseMuneco;
import juegoAhorcado.jugador;

public class CampoDeBatalla {
	private String nombreBatalla="La Batalla por la Tierra";
	Humano humanos[]= new Humano[20];
	Malvado malvados[]= new Malvado[20];
	private String ganadores="";
	private static CampoDeBatalla campo = null;
	
	public CampoDeBatalla() {
		// Creamos los personajes
		for(int i=0;i<20;i++){
			int nuevaVida=(int) Math.round(Math.random() * ((100) - 50) + 50);
			humanos[i]= new Humano("Terricola "+(i+1),nuevaVida,true,0);
			System.out.println(humanos[i].toString());

			nuevaVida=(int) Math.round(Math.random() * ((100) - 50) + 50);
			malvados[i]= new Malvado("StriborXZ "+(i+1),nuevaVida,true,0);
			System.out.println(malvados[i].toString());

		}
		
		//Damos el doble de vida a los últimos objetos
		humanos[humanos.length-1].setPuntosVida(humanos[humanos.length-1].getPuntosVida()*2);
		malvados[malvados.length-1].setPuntosVida(malvados[malvados.length-1].getPuntosVida()*2);

		//Mezclamos los personajes
		System.out.println("Mezclamos los personajes");

		for(int i=0;i<200;i++) {
			int numAle=(int) Math.round(Math.random() * ((19) - 0) + 0);
			int numAle2=(int) Math.round(Math.random() * ((19) - 0) + 0);
			Humano aux=humanos[numAle];
			Humano aux2=humanos[numAle2];
			humanos[numAle]=aux2;
			humanos[numAle2]=aux;
			
		}
		System.out.println("Bienvenidos a "+this.nombreBatalla);
	}
	// Bucle del juego
	public void inicioJuego() {
		do {
			int humanoVivo=0;
			int malvadoVivo=0;
			//Conseguimos un humano vivo
			for(int i=0;i<20;i++) {
				if(humanos[i].getPuntosVida()>0) {
					humanoVivo=i;
				}
			}
			//Conseguimos un malvado vivo
			for(int i=0;i<20;i++) {
				if(malvados[i].getPuntosVida()>0) {
					malvadoVivo=i;
				}
			}
			//Dispara el humano
			int generaDisparo=(int) Math.round(Math.random() * ((25) - 5) + 5);
			malvados[malvadoVivo].setPuntosVida(malvados[malvadoVivo].getPuntosVida()-generaDisparo);
			malvados[malvadoVivo].setDisparosRecibidos(malvados[malvadoVivo].getDisparosRecibidos()+1);
			System.out.println(humanos[humanoVivo].getNombre()+" dispara a "+malvados[malvadoVivo].getNombre()+" por "+generaDisparo+" puntos de vida");
			//Dispara el malvado
			generaDisparo=(int) Math.round(Math.random() * ((25) - 5) + 5);
			humanos[humanoVivo].setPuntosVida(humanos[humanoVivo].getPuntosVida()-generaDisparo);
			humanos[humanoVivo].setDisparosRecibidos(humanos[humanoVivo].getDisparosRecibidos()+1);
			System.out.println(malvados[malvadoVivo].getNombre()+" dispara a "+humanos[humanoVivo].getNombre()+" por "+generaDisparo+" puntos de vida");

			
		}while(!isTerminado());
		
		//Mostramos los disparos recibidos por cada personaje y comprobamos el mas facil y el mas dificil de matar
		int disparosMaximosHumanos=0;
		int disparosMinimosHumanos=1000;
		int disparosMaximosMalvados=0;
		int disparosMinimosMalvados=1000;
		Humano humanoDificil=null;
		Humano humanoFacil=null;
		Malvado malvadoDificil=null;
		Malvado malvadoFacil=null;
		
		for(int i=0;i<20;i++) {
			//Mostramos los disparos recibidos
			System.out.println(humanos[i].getNombre()+" ha recibido "+humanos[i].getDisparosRecibidos()+" disparos");
			//Conseguimos el humano mas dificil y facil
			//Anadimos el && para que algunas veces no de la casualidad de que coja uno vivo
			if(humanos[i].getDisparosRecibidos()>disparosMaximosHumanos && !humanos[i].isVivo()) {
				disparosMaximosHumanos=humanos[i].getDisparosRecibidos();
				humanoDificil=humanos[i];
			}
			if(humanos[i].getDisparosRecibidos()<disparosMinimosHumanos && !humanos[i].isVivo()) {
				disparosMinimosHumanos=humanos[i].getDisparosRecibidos();
				humanoFacil=humanos[i];
			}
		}
		for(int i=0;i<20;i++) {
			//Mostramos los disparos recibidos
			System.out.println(malvados[i].getNombre()+" ha recibido "+malvados[i].getDisparosRecibidos()+" disparos");
			//Conseguimos el malvado mas dificil y facil
			if(malvados[i].getDisparosRecibidos()>disparosMaximosMalvados && !malvados[i].isVivo()) {
				disparosMaximosMalvados=malvados[i].getDisparosRecibidos();
				malvadoDificil=malvados[i];
			}
			if(malvados[i].getDisparosRecibidos()<disparosMinimosMalvados && !malvados[i].isVivo()) {
				disparosMinimosMalvados=malvados[i].getDisparosRecibidos();
				malvadoFacil=malvados[i];
			}
		}
		
		//Mostramos quien ha ganado
		System.out.println(this.ganadores);
		//Mostramos los mas dificil y faciles
		System.out.println("Humano mas dificil de matar: ");
		System.out.println(humanoDificil.toString());
		System.out.println("Humano mas facil de matar: ");
		System.out.println(humanoFacil.toString());
		System.out.println("Malvado mas dificil de matar: ");
		System.out.println(malvadoDificil.toString());
		System.out.println("Malvado mas facil de matar: ");
		System.out.println(malvadoFacil.toString());
	}
	
	public boolean isTerminado () { // mientras haya algun personaje vivo en los 2 bandos no esta terminado
		int vivosHumanos=0;
		int vivosMalvados=0;
		for(int i=0;i<20;i++) {
			if(humanos[i].getPuntosVida()<=0) {
				humanos[i].setVivo(false);
			}
			if(humanos[i].isVivo()) {
				vivosHumanos=1;
			}
			
		}
		for(int i=0;i<20;i++) {
			if(malvados[i].getPuntosVida()<=0) {
				malvados[i].setVivo(false);
			}
			if(malvados[i].isVivo()) {
				vivosMalvados=1;
			}
		}
		
		if (vivosHumanos==0 | vivosMalvados==0) {
			// Introducimos el bando ganador
			if(vivosHumanos==0) {
				this.ganadores="Ganan los malvados";

			}else {
				this.ganadores="Ganan los humanos";
			}
			return true;
		}
		return false;
	}
	
	// to String de nuestros personajes
	public void imprimir() {
		for(int i=0;i<20;i++) {
			System.out.println(humanos[i].toString());
			System.out.println(malvados[i].toString());
		}
	}
	// Single-ton de Campo de Batalla
	public static CampoDeBatalla getCampo() {
		if (campo == null) {
			campo = new CampoDeBatalla();
		}
		return campo;
	}
}
