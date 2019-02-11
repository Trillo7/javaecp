package Arkanoid;

import java.util.ArrayList;
import java.util.List;

/**
 * Todas las fases deber�n extender esta clase abstracta y personalizar la apariencia y el comportamiento
 * @author R
 *
 */
public abstract class Fase {
	
	// Lista de actores a colocar en cualquier fase
	protected List<Actor> actors = new ArrayList<Actor>();
	
	// M�todo que debe implementar cada Fase
	public abstract void inicializaFase ();

	// Getter de la lista de actores
	public List<Actor> getActores() { return actors; }
	
	// Archivo de sonido del principio de la fase
	public String getNombreSonidoInicio () {
		return "Arkanoid-start-of-stage.wav";
	}
}
