package examenFeb;

public class SupervisorCaja implements DevolverListener {

	@Override
	public void DevolverArticulo(DevolverEvent evento) {
		// TODO Auto-generated method stub
		System.out.println("Supervisor - Devuelto: "+evento.getArticulo().nombre+" - "+evento.getArticulo().fechaDated);
	}

}
