package formula1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

// La clase extiende de Canvas, se trata de un lienzo sobre el cual podemos pintar
// libremente.
public class VentanaPodium extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto de la ventana
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private static VentanaPodium ventana=null;
	private String textoFinal=" ";
	private String palabraAdivinar="";
	private String temporada="oeste";
	private Color colorActual=Color.blue;
	static JFrame jframe;
	
	
	public VentanaPodium () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		//JFrame ventana = new JFrame("El Ahorcado HD by Trillo");
		// Como hacer para que la Ronda no se refresca el numero en la ventana
		jframe = new JFrame("El Podium");

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
				
		//Podium
		g.drawImage(CacheImagenes.getCache().getPodium(), 50, 100, this);
		

		//Dibujamos los vehiculos
			g.drawString(""+Juego.getInstance().getVehiculos()[Juego.getInstance().getPodium()[0]].getNombreVehiculo(),150, 55);
			g.drawString(""+Juego.getInstance().getVehiculos()[Juego.getInstance().getPodium()[1]].getNombreVehiculo(),90, 155);
			g.drawString(""+Juego.getInstance().getVehiculos()[Juego.getInstance().getPodium()[2]].getNombreVehiculo(),345, 240);

	}

	// Single-ton de ventana
	public static VentanaPodium getVentana() {
		if (ventana == null) {
		ventana = new VentanaPodium();
		}
		return ventana;
	}
	
	public static void setTitle (String newTitle) {
		jframe.setTitle(newTitle);
	}
}
