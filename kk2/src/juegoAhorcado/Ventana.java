package juegoAhorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
	public static final int WIDTH = 734;
	public static final int HEIGHT = 740;
	private static Ventana ventana=null;
	private String textoFinal=" ";
	private String palabraAdivinar="";
	private String temporada="oeste";
	private Color colorActual=Color.blue;
	static JFrame jframe;
	
	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		//JFrame ventana = new JFrame("El Ahorcado HD by Trillo");
		// Como hacer para que la Ronda no se refresca el numero en la ventana
		jframe = new JFrame("El Ahorcado HD by Trillo - Ronda "+jugador.getJugador().getRondas());

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
		
		// Pintamos fondo y color segun la temporada
		if(temporada.equals("oeste")) {
			g.drawImage(CacheImagenes.getCache().getahorcadoFondo(), 0, 0, this);
			colorActual=Color.blue;
			// Fondo color marcos (recuadro)
			g.setColor(Color.white);
			g.fillRect(0, 578, 733, 132);
		}else if(temporada.equals("navidad")) {
			colorActual=Color.red;
			g.drawImage(CacheImagenes.getCache().getahorcadoFondoNavidad(), 0, 0, this);
			// Fondo color marcos (recuadro)
			g.setColor(Color.white);
			g.fillRect(0, 578, 733, 132);
		}else if(temporada.equals("verano")) {
			g.drawImage(CacheImagenes.getCache().getahorcadoFondoVerano(), 0, 0, this);
			colorActual=Color.yellow;
			// Fondo color marcos (recuadro)
			g.setColor(Color.black);
			g.fillRect(0, 578, 733, 132);
		}
		
		/** PORQUE FLASHEA
		 // Pintamos fondo y color segun la temporada
		g.drawImage(CacheImagenes.getCache().getahorcadoFondo(), 0, 0, this);

		if(temporada.equals("oeste")) {
			colorActual=Color.blue;
			// Fondo color marcos (recuadro)
			g.setColor(Color.white);
			g.fillRect(0, 578, 733, 132);
		}else if(temporada.equals("navidad")) {
			colorActual=Color.red;
			// Fondo color marcos (recuadro)
			g.setColor(Color.white);
			g.fillRect(0, 578, 733, 132);
		}else if(temporada.equals("verano")) {
			colorActual=Color.yellow;
			// Fondo color marcos (recuadro)
			g.setColor(Color.black);
			g.fillRect(0, 578, 733, 132);
		}
		*/
		// Techo tabla de colgar
		g.setColor(new Color(102, 51, 0));
		g.fillRect(335, 50, 440, 35);

		// Muro tabla de colgar
		g.fillRect(690, 40, 80, 538);
		
		// Silla
		if(jugador.getJugador().getNumintentos()>=1) {
			g.fillRect(492, 378, 65, 7);
			g.fillRect(505, 378, 7, 50);
			g.fillRect(535, 378, 7, 50);
		}
		
		// Pintamos la cabeza
		if(jugador.getJugador().getNumintentos()>=1) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillOval(495, 140, 60, 60);
		
		//Dibujamos la cara
		// Ojos
		g.setColor(Color.blue);
		if(jugador.getJugador().getNumintentos()<1) {
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
        
		// Pintamos la cuerda
		g.setColor(new Color(102, 51, 0));
		g.drawRect(525, 55, 1, 85);
		g.fillRect(510, 197, 30, 3);
		
		// Pintamos el cuerpo
		if(jugador.getJugador().getNumintentos()>=2) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(500, 200, 50, 90);
		
		// Pintamos brazo izquierdo
		if(jugador.getJugador().getNumintentos()>=3) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(478, 200, 20, 65);
		
		// Pintamos brazo derecho
		if(jugador.getJugador().getNumintentos()>=4) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(552, 200, 20, 65);
		
		// Pintamos pierna izquierda
		if(jugador.getJugador().getNumintentos()>=5) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(502, 290, 20, 85);
		
		// Pintamos pierna derecha
		if(jugador.getJugador().getNumintentos()>=6) {
			g.setColor(new Color(253, 221, 202));
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(528, 290, 20, 85);
        
    	// Marcos
		//Recuadro global del juego (Adivina _ _ _)
		g.setColor(colorActual);
		g.drawRect(0, 578, 733, 132);
		
		//Recuadro rojo derecha (vidas)
		g.drawRect(550, 578, 182, 132);
		
		// Pintamos cartel de Ronda
		g.setColor(new Color(102, 51, 0));
		g.fillRect(355, 105, 70, 40);
			// Palos del cartel
		g.fillRect(365, 85, 7, 30);
		g.fillRect(405, 85, 7, 30);
		
        // TEXTOS
		g.setColor(colorActual);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 28)); 
	
		// Pintamos las palabras fallidas(intentos) FALLOS
		g.drawString("Fallos: "+jugador.getJugador().getPalabrasFallidas(),10,30);
		
		//Pintamos los comodines HINT
        g.setFont(new Font("Segoe UI", Font.PLAIN, 14)); 
		g.drawString("Comodin hint: ",10,60);
		if(jugador.getJugador().getHint()==1) {
			g.setColor(Color.red);
			g.drawString("Usado",108,60);
		}else {
			g.setColor(Color.green);
			g.drawString("Disponible",108,60);
		}

		//Pintamos la temporada actual TEMPORADA
		g.setColor(Color.blue);
		g.drawString("Tema de temporada: ",10,80);
		g.drawString(this.temporada,155,80);

		// Pintamos las rondas que llevamos RONDAS
		g.setColor(Color.white);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 15)); 
		g.drawString("Ronda "+jugador.getJugador().getRondas(),360,130);
		
		// Pintamos la palabra adivinacion ADIVINA
		g.setColor(colorActual);
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

	// Single-ton de ventana
	public static Ventana getVentana() {
		if (ventana == null) {
		ventana = new Ventana();
		}
		return ventana;
	}
	
	
	public static void setTitle (String newTitle) {
		jframe.setTitle(newTitle);
	}
}
