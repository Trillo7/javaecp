package formula1;

public class ManchaAceite extends Obstaculo {

	
	public ManchaAceite() {
		super();
		// TODO Auto-generated constructor stub
		inicializa();
	}

	@Override
	void inicializa() {
		// TODO Auto-generated method stub
		this.setAccion((int) Math.round(Math.random() * ((-50) - -10) + -10));
	}

}
