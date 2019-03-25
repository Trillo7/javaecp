package repasoFeb.Bloque8Swing.Ejer2General;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal () {
		super("Ejercicio General");
		this.setBounds(0, 0, 800, 600);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPanel = new JTabbedPane();		
		tabbedPanel.add("01", getPanelTab01());		
		tabbedPanel.add("02",getPanelTab02());
		
		this.setContentPane(tabbedPanel);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelTab01 () {		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("Una etiqueta"));

		JTextField jtf = new JTextField("Texto", 40);
		panel.add(jtf);
		
		JCheckBox check = new JCheckBox("Esto es un check");
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cambiado el estado del check a : " + check.isSelected());
			}
		});
		panel.add(check);
		
		JButton jbt = new JButton ("Aceptar");
		jbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "Contenido del JTextField: " + jtf.getText() +
						" - Check: " + check.isSelected();
				JOptionPane.showMessageDialog(null, str);
			}
		});
		
		panel.add(jbt);
		
		return panel;
	}
	
	private JPanel getPanelTab02() {
		// INICIO TAB 2 //
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new FlowLayout());
		JLabel lbl=new JLabel("Esto es una label");
		panel2.add(lbl);
		panel.add(panel2);

		JPanel panel3=new JPanel();
		panel3.setLayout(new FlowLayout());
		JTextField txtfield=new JTextField("Escribe texto aqui",40);
		panel3.add(txtfield);
		panel.add(panel3);
		
		JPanel panel4=new JPanel();
		panel4.setLayout(new FlowLayout());
		JPasswordField jpass=new JPasswordField("",40);
		panel4.add(jpass);
		panel.add(panel4);
		
		JPanel panel5=new JPanel();
		panel5.setLayout(new FlowLayout());
		String[] womboCombo = {
		         "A",
		         "B",
		         "C",
		         "D",
		         "A",
		         "R",
		         "I",
		         "O"
		};
		JComboBox Combobox = new JComboBox(womboCombo);		
		panel5.add(Combobox);
		panel.add(panel5);
		
		JPanel panel6=new JPanel();
		panel6.setLayout(new FlowLayout());
		JList jlista=new JList(womboCombo);
		panel6.add(jlista);
		panel.add(panel6);
		
		JPanel panel7=new JPanel();
		panel7.setLayout(new FlowLayout());
		JButton buttoncito=new JButton("Cambiar color");
		panel7.add(buttoncito);
		panel.add(panel7);
		
		
		return panel;
		
		
	}
	
	
	
	public static void main (String args[]) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
