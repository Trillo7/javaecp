package formula1;
import java.io.*;
import sun.audio.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;

// La clase extiende de Canvas, se trata de un lienzo sobre el cual podemos pintar
// libremente.
public class Ventana extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto de la ventana
	public static final int WIDTH = 802;
	public static final int HEIGHT =929;
	private static Ventana ventana=null;
	private String textoFinal=" ";
	private String palabraAdivinar="";
	private String temporada="oeste";
	private Color colorActual=Color.blue;
	static JFrame jframe;
	
	
	public Ventana () throws Exception{
		//SONIDO CONTINUO

        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("/home/diurno/git/javaecp/formula1/src/formula1/assets/machines.au"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        //Thread.sleep(10000); // looping as long as this thread is alive
        
		
		  // open the sound file as a Java input stream
	   /**
        String gongFile = "/home/diurno/git/javaecp/formula1/src/formula1/assets/formula1.au";
	    InputStream in = new FileInputStream(gongFile);

	    // create an audiostream from the inputstream
	    AudioStream audioStream = new AudioStream(in);

	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);
	    */
	    // FIN SONIDO
		// La clase JFrame nos permite mostrar una ventana en pantalla
		// Como hacer para que la Ronda no se refresca el numero en la ventana
		jframe = new JFrame("Juego de Formula 1");

		// Establecemos las dimensiones que queremos que tenga
		jframe.setBounds(0,0,WIDTH,HEIGHT);
		
		// Obtengo una referencia al panel principal de la ventana.
		// Todas las ventanas tienen un panel principal	
		JPanel panel = (JPanel)jframe.getContentPane();

		// Al panel principal de la ventana le a�adimos el objeto this, un Canvas
		panel.add(this);

		// Establezco el tama�o del canvas (this) para que ocupe todo el tama�o de la ventana
		this.setBounds(0,0,WIDTH,HEIGHT);
		
		// Provocamos que el programa se acabe cuando cerramos la ventana 
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Hacemos visible la ventana.
		jframe.setVisible(true);
		// Evitamos que la ventana pueda redimensionarse.
		jframe.setResizable(false);
		
	}
	
	/**
	 * Sobrescribimos el m�todo "paint" que tienen todos los componentes gr�ficos en AWT-SWING
	 */
	@Override
	public void paint(Graphics g) {
		

		//Pista
		g.drawImage(CacheImagenes.getCache().getAsfalto(), 0, 0, this);
		g.drawImage(CacheImagenes.getCache().getAsfalto(), 0, 180, this);
		g.drawImage(CacheImagenes.getCache().getAsfalto(), 0, 360, this);
		g.drawImage(CacheImagenes.getCache().getAsfalto(), 0, 540, this);
		g.drawImage(CacheImagenes.getCache().getAsfalto(), 0, 720, this);
		
		//Dibujamos los obstaculos
		int altura=50;
		for(int x=0;x<5;x++){
			for(int i=0;i<4;i++) {
				if(Juego.getInstance().pistas[x].getObstaculos()[i].getPisado()==0) {
					if(Juego.getInstance().pistas[x].getObstaculos()[i] instanceof Rampa) {
						g.drawImage(CacheImagenes.getCache().getRampa(), Juego.getInstance().pistas[x].getObstaculos()[i].getPosicion(), altura, this);
					}else {
						g.drawImage(CacheImagenes.getCache().getMancha(), Juego.getInstance().pistas[x].getObstaculos()[i].getPosicion(), altura, this);

					}
				}
			}
			altura=altura+180;

		}
	
		//Dibujamos los vehiculos
		for(int i=0;i<5;i++) {
			Juego.getInstance().getVehiculos()[i].paint(g);
		}

	}
	
	// Single-ton de ventana
	public static Ventana getVentana() throws Exception {
		if (ventana == null) {
		ventana = new Ventana();
		}
		return ventana;
	}
	
	
	public static void setTitle (String newTitle) {
		jframe.setTitle(newTitle);
	}
}
