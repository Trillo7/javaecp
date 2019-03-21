package SWING.Ejer1GestionBasica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.corba.se.spi.ior.TaggedComponentFactoryFinder;

import BBDD.ConnectionManagerV2;
import BBDD.ImposibleConectarException;


public class VentanaPrincipal extends JFrame {
	JTextField tfId;
	JTextField tfCif;
	JTextField tfNombre;
	
	public VentanaPrincipal() {
		super("Primera gestión Fabricante");
		
		// Tama�o por defecto, basado en los valores est�ticos de esta misma clase
		setDimensionesBasicas();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Construcci�n elementos b�sicos sobre el ContentPanel
		this.setContentPane(getPanelPrincipal());

	}
			
			
	private JPanel getPanelPrincipal () {
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(getPanelId());
		panel.add(getPanelCif());
		panel.add(getPanelNombre());
		panel.add(getPanelButton());
		
		return panel;
	}
	
	private JPanel getPanelId() {
		JPanel panel=new JPanel();
		JLabel lbl= new JLabel("ID: ");
		tfId=new JTextField();
		tfId.setColumns(20);
		panel.add(lbl);
		panel.add(tfId);
		return panel;
	}
	
	private JPanel getPanelCif() {
		JPanel panel=new JPanel();
		JLabel lbl=new JLabel("CIF: ");
		tfCif=new JTextField();
		tfCif.setColumns(20);
		panel.add(lbl);
		panel.add(tfCif);
		
		return panel;
	}
	
	private JPanel getPanelNombre() {
		JPanel panel=new JPanel();
		JLabel lbl=new JLabel("Nombre: ");
		tfNombre=new JTextField();
		tfNombre.setColumns(20);
		panel.add(lbl);
		panel.add(tfNombre);
		
		return panel;
	}
	
	private JPanel getPanelButton() {
		JPanel panel=new JPanel();
		JButton button=new JButton("Guardar en BBDD");
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guardar();
			}
		});
		
		return panel;
		
	}
	
	private void guardar() {
		try {
			Connection conn =ConnectionManagerV2.getConexion();
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO tutorialjavacoches.fabricante(id, cif, nombre) VALUES(?,?,?)");
			ps.setInt(1, Integer.parseInt(tfId.getText()));
			ps.setString(2, tfCif.getText());
			ps.setString(3, tfNombre.getText());
			
			int filasafectadas= ps.executeUpdate();
			if(filasafectadas != 1) {
				throw new SQLException ("No ha sido posible la inserci�n con la cadena:\n");

			}else {
				JOptionPane.showMessageDialog(null, "Datos añadidos con exito");
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 800, 600);
	}
		
	
	
}
