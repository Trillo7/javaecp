package examenMarcianitos;

public class Malvado extends Personajes {

	public Malvado(String nombre, int puntosVida, boolean vivo, int disparosRecibidos) {
		super(nombre, puntosVida, vivo, disparosRecibidos);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Malvado [getNombre()=" + getNombre() + ", getPuntosVida()=" + getPuntosVida() + ", isVivo()=" + isVivo()
				+ ", getDisparosRecibidos()=" + getDisparosRecibidos() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
