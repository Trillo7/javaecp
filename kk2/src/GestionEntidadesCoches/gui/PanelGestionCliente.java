package GestionEntidadesCoches.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GestionEntidadesCoches.modelo.ControladorBBDDCliente;
import GestionEntidadesCoches.modelo.ControladorBBDDCoche;
import GestionEntidadesCoches.modelo.ControladorBBDDFabricante;
import GestionEntidadesCoches.modelo.entidades.Cliente;
import GestionEntidadesCoches.modelo.entidades.Coche;
import GestionEntidadesCoches.modelo.entidades.Fabricante;
import utils.CacheImagenes;


public class PanelGestionCliente extends JPanel {

	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField jtfId = new JTextField();
	JTextField jtfNombre = new JTextField();
	JTextField jtfApellidos = new JTextField();
	JTextField jtfLocalidad = new JTextField();
	JTextField jtfdniNie = new JTextField();
	JTextField jtfFechaNac = new JTextField();

	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	
	SimpleDateFormat formatDated=new SimpleDateFormat("dd/MM/yyyy");
	Cliente cliente = new Cliente(); //  mostrado en pantalla
	
	/**
	 * 
	 */
	public PanelGestionCliente () {
		
		this.maquetarVentana();
		
		// Manejo de la navegaci�n de registros por rueda de rat�n
		this.controlRuedaRaton();
		
		// Finalmente, despu�s de la construcci�n, cargamos el primer registro
		navegaAPrimero();
	}
	
	
	/**
	 * 
	 */
	private void controlRuedaRaton () {
		this.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getUnitsToScroll() < 0) {
					if (ControladorBBDDCliente.getSiguienteCliente(cliente) != null) {
						navegaASiguiente();
					}
				}
				else {
					if (ControladorBBDDCliente.getAnteriorCliente(cliente) != null) {
						navegaAAnterior();
					}
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private void maquetarVentana() {
		double pesoCol1 = 0.15, pesoCol2 = 1;
		
		this.setLayout(new GridBagLayout());

		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		// Incorporamos los components del Id
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Id:"), gridBagConstraints);
		
		colocaComponente(1, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfId, gridBagConstraints);
		
	
		// Incorporamos el Nombre
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Nombre:"), gridBagConstraints);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfNombre, gridBagConstraints);
		
		// Incorporamos los Apellidos
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Apellidos:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfApellidos, gridBagConstraints);
	
		// Incorporamos la Localidad
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Localidad:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfLocalidad, gridBagConstraints);
		
		// Incorporamos la dniNie
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("DNI:"), gridBagConstraints);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfdniNie, gridBagConstraints);
		
		// Incorporamos la fechaNac
		colocaComponente(0, 5, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Fecha de nacimiento:"), gridBagConstraints);
		
		colocaComponente(1, 5, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfFechaNac, gridBagConstraints);
		
		// Incorporamos fila botones
		colocaComponente(0, 6, GridBagConstraints.CENTER, 1, 1, GridBagConstraints.CENTER);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);		
	}
	
	
	/**
	 * 
	 */
	private JPanel getBotonera() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.setBackground(Color.gray);
		
		// Configuramos los botones
		configuraBoton(jbtNavPrimero, "gotostart.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAPrimero();
			}
		});
		configuraBoton(jbtNavAnterior, "previous.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAAnterior();
			}
		});
		configuraBoton(jbtNavSiguiente, "next.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaASiguiente();
			}
		});
		configuraBoton(jbtNavUltimo, "gotoend.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAUltimo();
			}
		});
		configuraBoton(jbtGuardar, "saveicon.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		configuraBoton(jbtNuevo, "newadd.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		configuraBoton(jbtEliminar, "deleteicon.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		//Inclu�mos los botones
		panel.add(jbtNavPrimero);
		panel.add(jbtNavAnterior);
		panel.add(jbtNavSiguiente);
		panel.add(jbtNavUltimo);
		panel.add(jbtGuardar);
		panel.add(jbtNuevo);
		panel.add(jbtEliminar);
		
		return panel;
	}

	
	/**
	 * 
	 */
	private void eliminar() {
		// Por regla general, siempre que eliminemos un coche navegaremos al siguiente
		// registro
		Cliente clienteAEliminar = this.cliente;
		
		// Compruebo si el coche actual es el �ltimo coche
		if (ControladorBBDDCliente.getUltimoCliente().getId() == this.cliente.getId()) {
			navegaAAnterior();
		}
		else {
			navegaASiguiente();
		}
		
		// Finalmente elimino el coche
		ControladorBBDDCliente.eliminarCliente(clienteAEliminar);
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	
	private void nuevo () {
		// Ponemos todos en blanco
		this.cliente = new Cliente();
		this.cliente.setId(-1);
		this.jtfNombre.setText("");
		this.jtfApellidos.setText("");
		this.jtfdniNie.setText("");
		this.jtfFechaNac.setText("");
		this.jtfLocalidad.setText("");
		this.jtfId.setText("");

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 * @param jbt
	 * @param icono
	 */
	private void configuraBoton (JButton jbt, String icono, ActionListener actionListener) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(actionListener);
	}
	
	
	
	private void guardar() {
		// Es un alta nueva o una modificaci�n
		cargaClienteDesdeComponentesVisuales();
		if (this.cliente.getId() == -1) { // Alta
			ControladorBBDDCliente.guardarNuevoCliente(this.cliente);
			this.navegaAUltimo();
		}
		else { // Modificaci�n
			ControladorBBDDCliente.modificarCliente(this.cliente);
		}

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void navegaAPrimero () {
		cliente = ControladorBBDDCliente.getPrimerCliente();
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAUltimo () {
		cliente = ControladorBBDDCliente.getUltimoCliente();
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaASiguiente () {
		cliente = ControladorBBDDCliente.getSiguienteCliente(this.cliente);
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAAnterior () {
		cliente = ControladorBBDDCliente.getAnteriorCliente(this.cliente);
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	
	
	/**
	 * 
	 */
	private void actualizaEstadoBotonera () {
		if (ControladorBBDDCliente.getAnteriorCliente(this.cliente) == null) {
			jbtNavPrimero.setEnabled(false);
			jbtNavAnterior.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
			jbtNavAnterior.setEnabled(true);
		}
		if (ControladorBBDDCliente.getSiguienteCliente(this.cliente) == null) {
			jbtNavSiguiente.setEnabled(false);
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavSiguiente.setEnabled(true);
			jbtNavUltimo.setEnabled(true);
		}
	}
	
	/**
	 * 
	 */
	private void cargaClienteEnComponentesVisuales () {
		this.jtfId.setText("" + cliente.getId());
		this.jtfNombre.setText(cliente.getNombre());
		this.jtfApellidos.setText(cliente.getApellidos());
		this.jtfdniNie.setText(cliente.getDniNie());
		this.jtfLocalidad.setText(cliente.getLocalidad());
		this.jtfFechaNac.setText(formatDated.format(cliente.getFechaNac()));

		
	}
	
	/**
	 * 
	 */
	private void cargaClienteDesdeComponentesVisuales () {
		this.cliente.setId((Integer.parseInt(this.jtfId.getText())));
		this.cliente.setNombre(this.jtfNombre.getText());
		this.cliente.setApellidos(this.jtfApellidos.getText());
		Date date = null;
		try {
			date = formatDated.parse ( this.jtfFechaNac.getText() );
			this.cliente.setFechaNac(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.cliente.setLocalidad(this.jtfLocalidad.getText());

		

	}
	
	/**
	 * 
	 * @param gridX
	 * @param gridY
	 * @param pesoColumna
	 * @param pesoFila
	 * @param fill
	 */
	private void colocaComponente (int gridX, int gridY, int anchor, double pesoColumna, double pesoFila, int fill) {
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.anchor = anchor;
		gridBagConstraints.weightx = pesoColumna;
		gridBagConstraints.weighty = pesoFila;
		gridBagConstraints.fill = fill;
		
	}
}
