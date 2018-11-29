package juegoAhorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

// La clase extiende de Canvas, se trata de un lienzo sobre el cual podemos pintar
// libremente.
public class Ventana extends Canvas {

	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto de la ventana
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	private static Ventana ventana=null;
	private String textoFinal=" ";
	private String palabraAdivinar="";
	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		JFrame ventana = new JFrame("El Ahorcado HD");
		// Establecemos las dimensiones que queremos que tenga
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		
		// Obtengo una referencia al panel principal de la ventana.
		// Todas las ventanas tienen un panel principal	
		JPanel panel = (JPanel)ventana.getContentPane();

		// Al panel principal de la ventana le a�adimos el objeto this, un Canvas
		panel.add(this);

		// Establezco el tama�o del canvas (this) para que ocupe todo el tama�o de la ventana
		this.setBounds(0,0,WIDTH,HEIGHT);
		
		// Provocamos que el programa se acabe cuando cerramos la ventana 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Hacemos visible la ventana.
		ventana.setVisible(true);
		// Evitamos que la ventana pueda redimensionarse.
		ventana.setResizable(false);
	}
	
	/**
	 * Sobrescribimos el m�todo "paint" que tienen todos los componentes gr�ficos en AWT-SWING
	 */
	@Override
	public void paint(Graphics g) {
		// Establecimiento del color del pincel
		g.setColor(Color.blue);

		// Pintamos la tabla de colgar 
		//Techo
		g.setColor(new Color(102, 51, 0));
		g.fillRect(20, 20, 500, 35);
		// Muro
		g.fillRect(20, 20, 40, 500);
		// Suelo
		g.fillRect(0, 410, 500, 45);
		
		// Pintamos la cuerda
		//g.drawLine(290, 60, 410,10);
		g.setColor(new Color(102, 51, 0));
		g.drawRect(325, 55, 1, 85);
		
		// Pintamos la cabeza
		
		if(jugador.getJugador().getNumintentos()>=1) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(295, 140, 60, 60);
		
		// Pintamos el cuerpo
		if(jugador.getJugador().getNumintentos()>=2) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(300, 200, 50, 90);
		
		// Pintamos brazo izquierdo
		if(jugador.getJugador().getNumintentos()>=3) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(278, 200, 20, 65);
		
		// Pintamos brazo derecho
		if(jugador.getJugador().getNumintentos()>=4) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(352, 200, 20, 65);
		
		// Pintamos pierna izquierda
		if(jugador.getJugador().getNumintentos()>=5) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(302, 290, 20, 85);
		
		// Pintamos pierna derecho
		if(jugador.getJugador().getNumintentos()>=6) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
	
		g.fillRect(328, 290, 20, 85);
		g.setColor(Color.blue);
		
		//Dibujamos la cara
		// Ojos
		if(this.textoFinal=="Has muerto") {
			g.setColor(Color.black);
			g.fillRect(312, 163, 8, 3);
			g.fillRect(315, 160, 3, 8);
			g.fillRect(332, 163, 8, 3);
			g.fillRect(335, 160, 3, 8);
		}else {
			g.setColor(Color.black);
			g.fillOval(312, 160, 6, 6);
			g.fillOval(333, 160, 6, 6);


		}
		
		// Pintamos las vidas
		g.drawString("Partes del cuerpo: "+jugador.getJugador().getNumintentos(), 450, 180);
		// Espacio para victoria o derrota
		g.drawString(textoFinal,450,193);
		// Pintamos el juego (palabra adivinacion)
		g.drawString("Juego: "+this.palabraAdivinar,450,280);
		// Pintamos las palabras fallidas(intentos)
		g.drawString("Fallos: "+jugador.getJugador().getPalabrasFallidas(),450,295);
		

	}
	
	/**
	 * @return the palabraAdivinar
	 */
	public String getPalabraAdivinar() {
		return palabraAdivinar;
	}

	/**
	 * @param palabraAdivinar the palabraAdivinar to set
	 */
	public void setPalabraAdivinar(String palabraAdivinar) {
		this.palabraAdivinar = palabraAdivinar;
	}



	/**
	 * @return the textoFinal
	 */
	public String getTextoFinal() {
		return textoFinal;
	}



	/**
	 * @param textoFinal the textoFinal to set
	 */
	public void setTextoFinal(String textoFinal) {
		this.textoFinal = textoFinal;
	}



	public static Ventana getVentana() {
		if (ventana == null) {
		ventana = new Ventana();
		}
		return ventana;
	}
}
