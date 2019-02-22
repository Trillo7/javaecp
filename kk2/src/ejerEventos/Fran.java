package ejerEventos;

public class Fran  extends IntStringIntroducidoAdapter  {

	@Override
	public void numeroImparIntroducido(IntStringEspecialIntroducidoEvent event) {
		System.out.println("Soy Fran, han introducido un n�mero impar: " + event.getNumeroIntroducido());
	}
	
	@Override
	public void stringIntroducido(IntStringEspecialIntroducidoEvent event) {
		super.stringIntroducido(event);
		System.out.println("Soy Fran, has introducido la palabra secreta: " + event.getStringIntroducido());
	}
}
