package repasoFeb;

import javax.swing.JOptionPane;

public class PattenPregMatchb3ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userpass=JOptionPane.showInputDialog("Introduce una contrase�a: ");
		while(!userpass.matches("^(?=.*\\W)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{4,}$")) {
			JOptionPane.showMessageDialog(null, "Introduce: \n"+
					"  - Al menos una may�scula.\r\n" + 
					"  - Al menos una min�scula.\r\n" + 
					"  - Al menos un d�gito\r\n" + 
					"  - Al menos un car�cter no alfanum�rico. ");
			userpass=JOptionPane.showInputDialog("Introduce una contrase�a: ");
		
		}


	}

}
