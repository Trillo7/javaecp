package Arkanoid;

import java.util.ArrayList;
import java.util.List;

import Arkanoid.Actor;

/**
 * Todas las fases deber�n extender esta clase abstracta y personalizar la apariencia y el comportamiento
 * @author R
 *
 */
public abstract class Fase {
	public int numIrrompibles=0;
	// Lista de actores a colocar en cualquier fase
	protected List<Actor> actors = new ArrayList<Actor>();
	
	// M�todo que debe implementar cada Fase
	public abstract void inicializaFase ();
	public int maxPills=0;
	public int actualPills=0;
	// Getter de la lista de actores
	public List<Actor> getActores() { return actors; }
	
	// Archivo de sonido del principio de la fase
	public String getGameplaySound () {
		return "fairytail-theme.wav";
	}
	public String getBackgroundImg() {
		return "background1.jpg";
	}

}
