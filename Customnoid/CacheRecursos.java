package Arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * 
 * @author R
 *
 */
public class CacheRecursos {
	// HashMap que act�a como almac�n de im�genes
	private HashMap<String, Object> hmRecursos = new HashMap<String, Object>();
	// Carpetas en la que se encuentran todos los recursos
	// Rutas desarrollo
	private String nombreCarpetaParaFile = "src/Arkanoid/soundUtils"; 
	private String nombreCarpetaParaURL = "/Arkanoid/soundUtils/"; 
	//Rutas compilado
//	private String nombreCarpetaParaFile = "./soundUtils"; 
//	private String nombreCarpetaParaURL = "/Arkanoid/soundUtils/"; 
	
	// Instancia Singleton
		private static CacheRecursos instancia= null;
		
		
		/**
		 * Getter Singleton
		 * @return
		 */
		public static CacheRecursos getInstancia () {
			if (instancia == null) {
				instancia = new CacheRecursos();
			}
			return instancia;
		}


		/**
		 * 
		 */
		public void cargarRecursosEnMemoria () {
			try {
				File carpeta = new File(nombreCarpetaParaFile);
				for (File fichero : carpeta.listFiles()) {
					System.out.println("fichero encontrado: " + fichero);
			        if (fichero.isFile()) {
			        	cargarFicheroEnHashMap(fichero.getName());
			        }
			    }
			}catch(Exception ex){
				System.out.println("ruta incorrecta");

			}
		}

		
		/**
		 * 
		 * @param nombreFichero
		 */
		private void cargarFicheroEnHashMap (String nombreFichero) {
			// Obtengo un objeto URL para localizar el recurso
			URL url = null;
			System.out.println("cargarFicheroEnHashMap: " + nombreCarpetaParaURL + nombreFichero);
			url = getClass().getResource(nombreCarpetaParaURL + nombreFichero);
			// Discriminar� el caso de que intento cargar un sonido del caso de cargar im�genes
			try {
				if (nombreFichero.endsWith(".wav") || nombreFichero.endsWith(".mp3")) {
					this.hmRecursos.put(nombreFichero, Applet.newAudioClip(url));
				} 
				else { // Si no es un sonido entiendo que se trata de una imagen
					this.hmRecursos.put(nombreFichero, ImageIO.read(url));
				}
			}
			catch (Exception ex) {
				System.out.println("No se pudo cargar el recurso " + nombreFichero);
				ex.printStackTrace();
			}
		}

		
		
		/**
		 * Mediante este m�todo casteamos a imagen el recurso que nos proporciona el supertipo
		 * @param name
		 * @return
		 */
		public BufferedImage getImagen(String nombreFichero) {
			return (BufferedImage) hmRecursos.get(nombreFichero);
		}

		
		/**
		 * Ejecuta un archivo de sonido de forma aislada
		 * @param name
		 */
		public void playSonido(String nombreFichero) {
			((AudioClip)hmRecursos.get(nombreFichero)).play();
		}
		
		/**
		 * Reproduce un archivo de sonido en bucle
		 * @param name
		 */
		public void loopSonido(final String nombreFichero) {
			System.out.println("hmRecursos: " + hmRecursos);
			System.out.println("nombreFichero: " + nombreFichero);
			System.out.println("mRecursos.get(nombreFichero): " + hmRecursos.get(nombreFichero));
			((AudioClip)hmRecursos.get(nombreFichero)).loop();
		}

		
	}
