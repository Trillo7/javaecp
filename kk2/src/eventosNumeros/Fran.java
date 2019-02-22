package eventosNumeros;

public class Fran  extends NumeroEspecialIntroducidoAdapter  {

	@Override
	public void numeroImparIntroducido(NumeroEspecialIntroducidoEvent event) {
		System.out.println("Soy Fran, han introducido un n�mero impar: " + event.getNumeroIntroducido());
	}

}
