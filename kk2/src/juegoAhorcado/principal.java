package juegoAhorcado;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// dudas: Como cambiar el array literal? en vez de manualmente
		// Como no hacer un metodo para cada imagen? Al utilizar el getImagen y mandarle el nombre del archivo de imagen como que se refrescaba mas? flashea
		// y tmb si en el getahorcadofondo cambiando las variables tmb flashea
		baseMuneco.getJuego().cargaJuego();
		baseMuneco.getJuego().iniciaJugada();
		
	}

}
