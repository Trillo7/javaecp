package kk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class builderpracticaED {

	private JFrame frame;
	private JTextField cajNumero2;
	private JTextField cajNumero1;
	private JTextField cajResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					builderpracticaED window = new builderpracticaED();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public builderpracticaED() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(400, 300));
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SUMADOR");
		lblNewLabel.setBounds(177, 12, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNumero = new JLabel("Numero 1");
		lblNumero.setBounds(32, 41, 70, 15);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNumero_1 = new JLabel("Numero 2");
		lblNumero_1.setBounds(32, 97, 70, 15);
		frame.getContentPane().add(lblNumero_1);
		
		cajNumero2 = new JTextField();
		cajNumero2.setBounds(133, 93, 114, 19);
		frame.getContentPane().add(cajNumero2);
		cajNumero2.setColumns(10);
		
		cajNumero1 = new JTextField();
		cajNumero1.setBounds(133, 39, 114, 19);
		frame.getContentPane().add(cajNumero1);
		cajNumero1.setColumns(10);
		
		cajResultado = new JTextField();
		cajResultado.setBounds(164, 170, 114, 19);
		frame.getContentPane().add(cajResultado);
		cajResultado.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(190, 139, 88, 15);
		frame.getContentPane().add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intcajNumero1=Integer.parseInt(cajNumero1.getText());
				int intcajNumero2=Integer.parseInt(cajNumero2.getText());
				//cajResultado.setText(""+intcajNumero1+intcajNumero2);
				int sumatotal=intcajNumero1+intcajNumero2;
				cajResultado.setText(""+sumatotal);
			}
		});
		btnCalcular.setBounds(32, 167, 117, 25);
		frame.getContentPane().add(btnCalcular);
	}
}
