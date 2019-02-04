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
	
	//sonido de inicio de juego del menu
	public void startMenu() {
		obj = new HiloSonidoBucle("Arkanoid/soundUtils/megamanBackground.wav");
		obj.start();
	}
	public void stopMenu() {
		obj.parar();
	}
	
	//sonido explosion
	public void explosionSound() {
		HiloSonido explosion = new HiloSonido("Arkanoid/soundUtils/explosionsfx.wav");
		explosion.start();
	}
	//sonido bola disparada
	public void blasterSound() {
		HiloSonido blaster = new HiloSonido("Arkanoid/soundUtils/blasterhansolo.wav");
		blaster.start();
	}
}