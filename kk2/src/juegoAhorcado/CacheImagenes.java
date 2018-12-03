package juegoAhorcado;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class CacheImagenes {
	
	// Patr�n Singleton
	private static CacheImagenes cache= null;
	
	// Variables con im�genes almacenadas
	private BufferedImage imagenTablero = null;
	private BufferedImage iconoLaOca = null;
	private BufferedImage ahorcadoFondo= null;
	private BufferedImage ahorcadoFondoNavidad= null;
	private BufferedImage ahorcadoFondoVerano= null;
	private BufferedImage IconoFinJuego= null;

	
	/**
	 * El constructor busca los archivos en el sistema y los carga en memoria
	 */
	public CacheImagenes () {
		super();
	}
	
	
	/**
	 * Getter del patr�n Singleton
	 * @return
	 */
	public static CacheImagenes getCache() {
		if (cache == null) {
			cache = new CacheImagenes();
		}
		return cache;
	}
	
	
	/**
	 * M�todo que permite obtener una imagen del sistema de ficheros. No es necesario que 
	 * en este momento de tu aprendizaje entiendas el 100% del siguiente m�todo. Es 
	 * demasiado complejo. S�lo tienes que entender que est� m�todo te devuelve un objeto
	 * de tipo BufferedImage, que podr�s utilizar para poder pintar un archivo de imagen
	 * sobre tu ventana.
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource("/juegoAhorcado/assets/" + nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}

	
	/**
	 * @return the ahorcadoFondo
	 */
	public BufferedImage getahorcadoFondo() {
		if (ahorcadoFondo == null) {
			ahorcadoFondo = getCache().getImagen("ahorcadoFondo.jpg");
		}
		return ahorcadoFondo;
	}
	public BufferedImage getahorcadoFondoNavidad() {
		if (ahorcadoFondoNavidad == null) {
			ahorcadoFondoNavidad = getCache().getImagen("ahorcadoFondoNavidad.jpg");
		}
		return ahorcadoFondoNavidad;
	}
	public BufferedImage getahorcadoFondoVerano() {
		if (ahorcadoFondoVerano == null) {
			ahorcadoFondoVerano = getCache().getImagen("ahorcadoFondoVerano.jpg");
		}
		return ahorcadoFondoVerano;
	}
	public BufferedImage getIconoFinJuego() {
		if (IconoFinJuego == null) {
			IconoFinJuego = getCache().getImagen("victoriamagistral.jpg");
		}
		return IconoFinJuego;
	}

}
