package GestionEntidadesCoches.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setBounds(0, 0, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane jtabbedPane = new JTabbedPane();
		
		jtabbedPane.add("Gestion de Coches", new PanelGestionCoche());
		jtabbedPane.add("Gestion de Fabricantes", new PanelGestionFabricante());
		jtabbedPane.add("Gestion de Clientes", new PanelGestionCliente());

		
		this.setContentPane(jtabbedPane);
	}
	
}
