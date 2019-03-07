package baseTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class Main2listener {
	public Main2listener() {
		System.out.println("creado");
		  JFrame frame = new JFrame("Key Listener");
		  
		  Container contentPane = frame.getContentPane();
		  
		  
		  KeyListener listener = new KeyListener() {
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
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			
				}
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					
				}

				if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			
				}
			}
		};
		  
		  JTextField textField = new JTextField();
		  
		  textField.addKeyListener(listener);
		 
		  contentPane.add(textField, BorderLayout.NORTH);
		 
		  frame.pack();
		 
		  frame.setVisible(true);
	}
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2listener main=new Main2listener();
		
	}

}
