package repasoFeb.Bloque7Eventos;

public class BuscaDigitos implements Ej1Listener {

	@Override
	public void EncuentraDigito(Ej1DigitoEncontradoEvent evento) {
		// TODO Auto-generated method stub
		System.out.println("Digito encontrado: "+evento.digito);
		
	}

}
