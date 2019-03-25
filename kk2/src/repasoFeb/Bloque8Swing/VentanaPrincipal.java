package repasoFeb.Bloque8Swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;


public class VentanaPrincipal extends JFrame {
	
	
	public VentanaPrincipal() {
		super("Ejercicio 1");
		
		setDimensionesBasicas();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setContentPane(getPanelPrincipal());

	}
			
			
	private JTabbedPane getPanelPrincipal () {
		JTabbedPane tabbedPanel=new JTabbedPane();

		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel("Una etiqueta"));
		JTextField jtf=new JTextField("Escribe aqui");
		panel.add(jtf);
		JCheckBox checkbox=new JCheckBox("Verificar");
		panel.add(checkbox);
		
		JButton jbt=new JButton("Aceptar");
		jbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="Contenido del JTextField: "+jtf.getText()+" - Checkbox: "+checkbox.isSelected();
				JOptionPane.showMessageDialog(null,str);
			}
		});
		checkbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="Contenido del Checkbox: "+checkbox.isSelected();
				JOptionPane.showMessageDialog(null,str);
			}
		});
		panel.add(jbt);

		tabbedPanel.add("01", panel);
		// INICIO TAB 2 //
		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Una etiqueta de Tab 2"));

		tabbedPanel.add("02", panel2);

		return tabbedPanel;
	}
	
	

	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 800, 600);
		this.setResizable(false);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaPrincipal ventana= new VentanaPrincipal();
		ventana.setVisible(true);
	}
	
	
}
