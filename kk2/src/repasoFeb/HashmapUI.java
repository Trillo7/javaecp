package repasoFeb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HashmapUI {
	private HashMap<String, Articulo> almacenmap = new HashMap<String, Articulo>();
	public String articuloslist="";

	
	public HashmapUI() {
		JFrame f=new JFrame("Aplicacion almacen");  
	    JButton b=new JButton("Añadir articulo");  
	    b.setBounds(100,80,195,30); 
	    f.add(b);
	    JButton c=new JButton("Borrar articulo");
	    c.setBounds(100,120,195,30); 
	    f.add(c);  
	    JButton d=new JButton("Actualizar estante");
	    d.setBounds(100,160,195,30); 
	    f.add(d); 
	    JButton e=new JButton("Mostrar articulos");
	    e.setBounds(100,200,195,30); 
	    f.add(e); 
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	    b.addActionListener(new PageActionListener(1));
	    c.addActionListener(new PageActionListener(2));
	    d.addActionListener(new PageActionListener(3));
	    e.addActionListener(new PageActionListener(4));

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashmapUI main=new HashmapUI();
	}
	//FUNCIONES BOTONES
	public void anadirarticulo() {
		System.out.println("Añadir articulo");
		String codigo=JOptionPane.showInputDialog("Codigo de barras: ");
		String estante=JOptionPane.showInputDialog("Introduce el estante: ");
		String descripcion=JOptionPane.showInputDialog("Introduce una breve descripcion: ");
		Articulo articulo=new Articulo(codigo,estante,descripcion);
		almacenmap.put(articulo.codigo, articulo);
	}
	
	public void borrararticulo() {
		System.err.println("Borrar articulo");
		muestraArticulos();
		String codigo=JOptionPane.showInputDialog("Codigo de barras del articulo a eliminar: ");
		almacenmap.remove(codigo);
	}
	public void actualizaEstante() {
		System.err.println("Actualizamos estante");
		muestraArticulos();
		String codigo=JOptionPane.showInputDialog("Codigo de barras del articulo a modificar estante: ");
		String estante=JOptionPane.showInputDialog("Introduce el estante nuevo: ");
		almacenmap.get(codigo).estante=estante;
	}
	public void muestraArticulos() {
		System.err.println("Mostramos articulos");
		System.out.println("\nRecorrido de los objetos del HashMap:");
		articuloslist="";
		Iterator<Articulo> personas = almacenmap.values().iterator();
		if(personas.hasNext()) {
			while (personas.hasNext()) {
				Articulo articulo=personas.next();
				articuloslist+=articulo.codigo+" - "+articulo.descripcion+"\n";
			}
			JOptionPane.showMessageDialog(null, articuloslist);
		}else {
			JOptionPane.showMessageDialog(null, "Lista vacia");

		}


	}
	private class PageActionListener implements ActionListener {
	    private int opcion;

	    public PageActionListener(int opcion) {
	        this.opcion = opcion;
	    }

	    public void actionPerformed(ActionEvent e) {
	        if(opcion==1) {
	        	anadirarticulo();
	        }
	        if(opcion==2) {
	        	borrararticulo();
	        }
	        if(opcion==3) {
	        	actualizaEstante();
	        }
	        if(opcion==4) {
	        	muestraArticulos();
	        }
	    }

	}
}
