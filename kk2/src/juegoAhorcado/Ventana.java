package juegoAhorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

// La clase extiende de Canvas, se trata de un lienzo sobre el cual podemos pintar
// libremente.
public class Ventana extends Canvas {

	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto de la ventana
	public static final int WIDTH = 734;
	public static final int HEIGHT = 740;
	private static Ventana ventana=null;
	private String textoFinal=" ";
	private String palabraAdivinar="";
	private String temporada="oeste";
	private Color colorActual=Color.blue;
	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		JFrame ventana = new JFrame("El Ahorcado HD by Trillo - Ronda "+jugador.getJugador().getRondas());
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
		
		// Pintamos fondo y color segun la temporada
		
		if(temporada.equals("oeste")) {
			g.drawImage(CacheImagenes.getCache().getahorcadoFondo(), 0, 0, this);
			colorActual=Color.blue;
		}else if(temporada.equals("navidad")) {
			g.drawImage(CacheImagenes.getCache().getahorcadoFondoNavidad(), 0, 0, this);
			colorActual=Color.red;
		}else if(temporada.equals("verano")) {
			g.drawImage(CacheImagenes.getCache().getahorcadoFondoVerano(), 0, 0, this);
			colorActual=Color.yellow;
			// Fondo marcos (recuadro)
			g.setColor(Color.black);
			g.fillRect(0, 578, 733, 132);
		}
		
		// Pintamos la tabla de colgar 
		//Techo
		g.setColor(new Color(102, 51, 0));
		//g.fillRect(235, 50, 540, 35);
		g.fillRect(335, 50, 440, 35);

		// Muro
		g.fillRect(690, 40, 80, 538);
		// Suelo
		//g.fillRect(0, 410, 500, 45);
		// Silla
		if(jugador.getJugador().getNumintentos()>=1) {
			g.fillRect(492, 378, 65, 7);
			g.fillRect(505, 378, 7, 50);
			g.fillRect(535, 378, 7, 50);
		}
		
		// Pintamos la cabeza
		if(jugador.getJugador().getNumintentos()>=1) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(495, 140, 60, 60);
		
		// Pintamos la cuerda
		//g.drawLine(290, 60, 410,10);
		g.setColor(new Color(102, 51, 0));
		g.drawRect(525, 55, 1, 85);
		g.fillRect(510, 197, 30, 3);
		
		// Pintamos el cuerpo
		if(jugador.getJugador().getNumintentos()>=2) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(500, 200, 50, 90);
		
		// Pintamos brazo izquierdo
		if(jugador.getJugador().getNumintentos()>=3) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(478, 200, 20, 65);
		
		// Pintamos brazo derecho
		if(jugador.getJugador().getNumintentos()>=4) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(552, 200, 20, 65);
		
		// Pintamos pierna izquierda
		if(jugador.getJugador().getNumintentos()>=5) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(502, 290, 20, 85);
		
		// Pintamos pierna derecho
		if(jugador.getJugador().getNumintentos()>=6) {
			g.setColor(Color.green);
		}else {
			g.setColor(Color.red);
		}
	
		g.fillRect(528, 290, 20, 85);
		g.setColor(Color.blue);
		
		//Dibujamos la cara
		// Ojos
		if(this.textoFinal=="Has muerto") {
			g.setColor(Color.black);
			// Cruz ojo izquierdo
			g.fillRect(512, 163, 10, 6);
			g.fillRect(515, 160, 5, 11);
			// Cruz ojo derecho
			g.fillRect(532, 163, 10, 6);
			g.fillRect(535, 160, 5, 11);
		}else {
			g.setColor(Color.white);
			g.fillOval(512, 160, 16, 16);
			g.fillOval(533, 160, 16, 16);
			g.setColor(Color.blue);
			g.fillOval(518, 164, 6, 6);
			g.fillOval(538, 164, 6, 6);
		}
		// Boca
		g.setColor(Color.red);
        g.fillArc(485, 182, 80, 20, 65, 50);
        
    	// Marcos
		g.setColor(colorActual);
		//g.fillRect(0, 540, 740, 500);
		
		//Recuadro rojo global
		//g.setColor(Color.red);
		g.drawRect(0, 578, 733, 132);
		//Recuadro rojo derecha (vidas)
		g.drawRect(550, 578, 182, 132);

        // TEXTOS
        g.setFont(new Font("Segoe UI", Font.PLAIN, 28)); 
	
		// Pintamos las palabras fallidas(intentos) FALLOS
		g.drawString("Fallos: "+jugador.getJugador().getPalabrasFallidas(),10,30);
		//Pintamos los comodines
        g.setFont(new Font("Segoe UI", Font.PLAIN, 14)); 
		g.drawString("Comodin hint: ",10,60);
		if(jugador.getJugador().getHint()==1) {
			g.setColor(Color.red);
			g.drawString("Usado",110,60);
		}else {
			g.setColor(Color.green);
			g.drawString("Disponible",110,60);
		}

		//Pintamos la temporada actual
		g.setColor(Color.blue);
		g.drawString("Tema de temporada: ",10,80);
		g.drawString(this.temporada,160,80);


		// Espacio para victoria o derrota ESTADO
        g.setFont(new Font("Segoe UI", Font.PLAIN, 15)); 
		g.drawString("Ronda "+jugador.getJugador().getRondas(),355,100);
		// Pintamos la palabra adivinacion ADIVINA
        g.setFont(new Font("Segoe UI", Font.PLAIN, 25)); 
		g.drawString("Adivina:",20,615);
		
        g.setFont(new Font("Impact", Font.ITALIC, 62)); 
		g.drawString(""+this.palabraAdivinar,20,675);

		// Pintamos las vidas VIDAS
        g.setFont(new Font("Segoe UI", Font.PLAIN, 28)); 
		g.setColor(colorActual);
		g.drawString("Vidas: ", 565, 615);
        g.setFont(new Font("Impact", Font.ITALIC, 62)); 
		g.drawString(""+jugador.getJugador().getNumintentos(), 618, 685);
	}
	
	/**
	 * @return the palabraAdivinar
	 */
	public String getPalabraAdivinar() {
		return palabraAdivinar;
	}
	
	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
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
