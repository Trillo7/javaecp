package repasoFeb;

import javax.swing.JOptionPane;

public class PattenPregMatchb3ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userpass=JOptionPane.showInputDialog("Introduce una contraseña: ");
		while(!userpass.matches("^(?=.*\\W)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{4,}$")) {
			JOptionPane.showMessageDialog(null, "Introduce: \n"+
					"  - Al menos una mayúscula.\r\n" + 
					"  - Al menos una minúscula.\r\n" + 
					"  - Al menos un dígito\r\n" + 
					"  - Al menos un carácter no alfanumérico. ");
			userpass=JOptionPane.showInputDialog("Introduce una contraseña: ");
		
		}


	}

}
