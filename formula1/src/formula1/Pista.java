package formula1;

import java.util.Arrays;

public class Pista {
	private Vehiculos corredor=null;
	private Obstaculo[] obstaculos=new Obstaculo[4];

	public Pista(Vehiculos corredor) {
		super();
		this.corredor = corredor;
		CargaObstaculos();
	}
	public void CargaObstaculos() {
		//Creamos los 4 obstaculos aleatorios
		for(int i=0;i<4;i++) {
			int aleat=(int) Math.round(Math.random() * ((1) - 0) + 0);
			if(aleat==1) {
				obstaculos[i]=new Rampa();

			}else {
				obstaculos[i]=new ManchaAceite();
			}
		}
		// Asignamos los obstaculos sin que se superpongan
		for(int i=0;i<4;i++) {
			boolean flag=false;
			int numposi=(int) Math.round(Math.random() * ((720) - 0) + 0);
			for(int x=0;x<4;x++) {
				if(numposi==obstaculos[x].getPosicion()) {
					flag=true;
				}// si alguna vez se activa la bandera vuelve a generar um numero
			}
			obstaculos[i].setPosicion(numposi);
			if (flag==true) {i--;}
			
		}
	}
	
	public Obstaculo[] getObstaculos() {
		return obstaculos;
	}
	public void setObstaculos(Obstaculo[] obstaculos) {
		this.obstaculos = obstaculos;
	}
	public Vehiculos getCorredor() {
		return corredor;
	}

	public void setCorredor(Vehiculos corredor) {
		this.corredor = corredor;
	}


	@Override
	public String toString() {
		return "Pista [corredor=" + corredor + ", obstaculos=" + Arrays.toString(obstaculos) + "]";
	}
	
}
