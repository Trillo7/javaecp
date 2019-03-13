package repasoFeb.Bloque3Wrappers;

import javax.swing.JOptionPane;

public class Ej2CharIs {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.out.println(contrasena());

	}

	private static String contrasena() {

		String contrasena;

		boolean sal = false;

		do {

			contrasena = JOptionPane.showInputDialog("Introduce contrasena");

			boolean mayus = false;

			boolean minus = false;

			boolean digit = false;

			boolean noalf = false;

			for (int i = 0; i < contrasena.length(); i++) {

				Character letra = contrasena.charAt(i);

				if (Character.isUpperCase(letra)) {

					mayus = true;

				} else if (Character.isLowerCase(letra)) {

					minus = true;

				} else if (Character.isDigit(letra)) {

					digit = true;

				} else {

					noalf = true;

				}

			}

			if (mayus && minus && digit && noalf) {

				sal = true;

			}

		} while (!sal);

		return contrasena;

	}

}