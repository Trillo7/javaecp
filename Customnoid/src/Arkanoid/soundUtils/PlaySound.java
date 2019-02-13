package Arkanoid.soundUtils;

public class PlaySound {

	
	// Variables de sonido
	public static PlaySound soundclass = null;
	static HiloSonidoBucle s1 = null;

	//constructor
	public PlaySound() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Sonido por argumento
	
	public void customLoop(String songname) {
		s1 = new HiloSonidoBucle("Arkanoid/soundUtils/"+songname);
		s1.start();
	}
	public void stopcustomLoop() {
		s1.parar();
	}
	public void startSound(String songname) {
		HiloSonido scustom = new HiloSonido("Arkanoid/soundUtils/"+songname);
		scustom.start();
	}
	//Sonidos predefinidos
	
	//sonido de fondo ronda 1
	public void background1Sound() {
		s1 = new HiloSonidoBucle("Arkanoid/soundUtils/fairytail-theme.wav");
		s1.start();
	}
	public void background2Sound() {
		s1= new HiloSonidoBucle("Arkanoid/soundUtils/megamanNebulaBackground.wav");
		s1.start();
	}
	//sonido de inicio de juego del menu
	public void startMenu() {
		s1 = new HiloSonidoBucle("Arkanoid/soundUtils/megamanBackground.wav");
		s1.start();
	}
	
	//sonido de fondo para
	public void background1Stop() {
		s1.parar();
	}
	//sonido de fondo para
	public void background2Stop() {
		s1.parar();
	}
	public void stopMenu() {
		s1.parar();
	}
	
    // Sonidos
	public void wooshSound() {
		HiloSonido woosh = new HiloSonido("Arkanoid/soundUtils/woosh.wav");
		woosh.start();
	}
	
	//sonido explosion
	public void explosionSound() {
		HiloSonido explosionsfx = new HiloSonido("Arkanoid/soundUtils/kboom.wav");
		explosionsfx.start();
	}
	//sonido bola disparada
	public void blasterSound() {
		HiloSonido blaster = new HiloSonido("Arkanoid/soundUtils/blasterhansolo.wav");
		blaster.start();
	}
	
	// Single-ton
	public static PlaySound getSound() {
		if (soundclass == null) {
			soundclass = new PlaySound();
		}
		return soundclass;
	}

}