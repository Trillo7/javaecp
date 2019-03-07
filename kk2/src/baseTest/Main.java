package baseTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Main {
	public Main() {
		System.out.println("creado");
		JFrame frame = new JFrame("Key Listener");
		frame.setPreferredSize(new Dimension(500,500));
		Container contentPane = frame.getContentPane();
		frame.pack();
		frame.setVisible(true);
	 
		frame.addKeyListener(new KeyAdapter() {
			@Override public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					System.out.println("hola espacio");
				}
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				
				}
				if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
				}
			}
		});
		  
	}
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main=new Main();
		
	}

}
