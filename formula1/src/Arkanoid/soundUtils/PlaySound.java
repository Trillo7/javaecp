package Arkanoid.soundUtils;

public class PlaySound {

	
	//variables usadas
	HiloSonidoBucle obj = null;
	public static PlaySound sonido = null;
	
	//singletone
	public static PlaySound getSound() {
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
	
	//sonido de fondo ronda 1
	public void background1Sound() {
		obj = new HiloSonidoBucle("Arkanoid/soundUtils/megamanNebulaBackground.wav");
		obj.start();
	}
	
	//sonido de fondo para
	public void background1Stop() {
		obj.parar();
	}
	
	//sonido de inicio de juego
	public void startGame() {
		HiloSonido aceite = new HiloSonido("Arkanoid/soundUtils/megamanBackground.wav");
		aceite.start();
	}
	
	//sonido rampa
	public void explosionSound() {
		HiloSonido rampa = new HiloSonido("Arkanoid/soundUtils/explosionsfx.wav");
		rampa.start();
	}
	
}