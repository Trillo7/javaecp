package tresenraya;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RatonEscuchadorAutentico extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Soy el rat�n escuchador aut�ntico y me han hecho clic");
	}

}
