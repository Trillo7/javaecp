package formula1;

public class Rampa extends Obstaculo {

	
	public Rampa() {
		super();
		// TODO Auto-generated constructor stub
		inicializa();
	}

	@Override
	void inicializa() {
		// TODO Auto-generated method stub
		this.setAccion((int) Math.round(Math.random() * ((100) - 50) + 50));
	}

}
