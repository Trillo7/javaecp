package ejerEventos;

public class Carlos extends IntStringIntroducidoAdapter {

	
	public Carlos () {
		Principal.addNumeroImparIntroducidoListener(this);
	}
	
	
	@Override
	public void numeroImparIntroducido(IntStringEspecialIntroducidoEvent event) {
		System.out.println("Soy Carlos, han introducido un n�mero impar: " + event.getNumeroIntroducido());
	}


	@Override
	public void numeroPrimoIntroducido(IntStringEspecialIntroducidoEvent event) {
		super.numeroPrimoIntroducido(event);
		System.out.println("Soy Carlos, han introducido un n�mero primo: " + event.getNumeroIntroducido());
	}
	
	@Override
	public void stringIntroducido(IntStringEspecialIntroducidoEvent event) {
		super.stringIntroducido(event);
		System.out.println("Soy Carlos, has introducido la palabra secreta: " + event.getStringIntroducido());
	}
	
	
	
}
