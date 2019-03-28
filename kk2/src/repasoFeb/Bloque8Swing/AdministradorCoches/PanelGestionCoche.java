package repasoFeb.Bloque8Swing.AdministradorCoches;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelGestionCoche extends JPanel {
	
	JTextField jtfId=new JTextField();
	JComboBox<String> jcombo=new JComboBox<String>();
	/**
	 * 
	 */
	
	public PanelGestionCoche() {
		double pesocol1=0.25;;
		double pesocol2=1;
		this.setLayout(new GridBagLayout());
		
		// Incorporamos los components del Id
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.anchor= GridBagConstraints.EAST;
		c.weightx=pesocol1;
		c.insets=new Insets(5,5,5,5);
		this.add(new JLabel("Id: "),c);
		
		c.gridx=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=pesocol2;;
		this.add(jtfId, c);
		
		// Incorporamos el fabricante
		c.gridx=0;
		c.gridy=1;
		c.weightx=pesocol1;
		this.add(new JLabel("Fabricante: "),c);

	}
}
