package eventosNumeros;

public class Carlos extends NumeroEspecialIntroducidoAdapter {

	
	public Carlos () {
		Principal.addNumeroImparIntroducidoListener(this);
	}
	
	
	@Override
	public void numeroImparIntroducido(NumeroEspecialIntroducidoEvent event) {
		System.out.println("Soy Carlos, han introducido un n�mero impar: " + event.getNumeroIntroducido());
	}


	@Override
	public void numeroPrimoIntroducido(NumeroEspecialIntroducidoEvent event) {
		super.numeroPrimoIntroducido(event);
		System.out.println("Soy Carlos, han introducido un n�mero primo: " + event.getNumeroIntroducido());
	}
	
	
	
}
