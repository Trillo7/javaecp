package SWING.Ejer1GestionBasica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				initData();
			}
		});
		
		return panel;
		
	}
	
	private void initData() {
		try {
			Connection conn =ConnectionManagerV2.getConexion();
			
			PreparedStatement ps=conn.prepareStatement("SELECT * from tutorialjavacoches.fabricante where id=?");
			ps.setInt(1, Integer.parseInt(tfId.getText()));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				actualizar();
			}else {
				guardar();
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
	
	private void actualizar() {
		try {
			System.out.println("update");
			Connection conn =ConnectionManagerV2.getConexion();
			
			PreparedStatement ps=conn.prepareStatement("UPDATE tutorialjavacoches.fabricante set cif=?, nombre=? where id=?");
			ps.setString(1, tfCif.getText());
			ps.setString(2, tfNombre.getText());
			ps.setInt(3, Integer.parseInt(tfId.getText()));
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Datos actualizados con éxito");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void guardar() {
		
	}
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 800, 600);
	}
		
	
	
}
