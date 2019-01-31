package Arkanoid.soundUtils;

public class PlaySound {

	
	//variables usadas
	HiloSonidoBucle obj = null;
	public static PlaySound sonido = null;
	
	//singletone
	public static PlaySound getSonido() {
		if (sonido == null) {
			sonido = new PlaySound();
		}
		return sonido;
	}

	//constructor
	public PlaySound() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//sonido ralenti inicio
	public void gameplaybackgroundSound() {
		obj = new HiloSonidoBucle("Arkanoid/soundUtils/megamanNebulaBackground.wav");
		obj.start();
	}
	
	//sonido ralenti para
	public void ralentiStop() {
		obj.parar();
	}
	
	//sonido aceite
	public void startGame() {
		HiloSonido aceite = new HiloSonido("Arkanoid/soundUtils/megamanBackground.wav");
		aceite.start();
	}
	
	//sonido rampa
	public void crumblingSound() {
		HiloSonido rampa = new HiloSonido("Arkanoid/soundUtils/rampa.wav");
		rampa.start();
	}
	
}