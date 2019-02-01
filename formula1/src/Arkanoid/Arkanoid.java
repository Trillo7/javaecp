package Arkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Arkanoid.soundUtils.PlaySound;

public class Arkanoid extends Canvas implements KeyListener {
	
	private BufferStrategy strategy;
	private long usedTime;
	private Player player;
	private Ball ball;
	private List<Actor> actors = new ArrayList<Actor>();
	private List<Actor> explosionlist = new ArrayList<Actor>();
	public static final int WIDTH=701;
	public static final int HEIGHT=750;
	public static final int PLAY_HEIGHT = 670; 
	public static final int SPEED=10;
	private static Arkanoid instance = null;

	public Arkanoid() {
		
		JFrame ventana = new JFrame("Arkanoid HD by Trillo");
		JPanel panel = (JPanel)ventana.getContentPane();
		setBounds(0,0,Arkanoid.WIDTH,Arkanoid.HEIGHT);
		panel.setPreferredSize(new Dimension(Arkanoid.WIDTH,Arkanoid.HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,Arkanoid.WIDTH,Arkanoid.HEIGHT);
		ventana.setVisible(true);		
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addMouseMotionListener( new MouseMotionAdapter() {
			
			@Override 
			public void mouseMoved(MouseEvent e) { //SENSOR RATON
				// TODO Auto-generated method stub
				player.setX(e.getX());
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		addKeyListener(this);
	}
	
	public void initWorld() {
	//Creamos los Bricks en arraylist
		//Sonido de fondo
		PlaySound.getSound().background1Sound();
		// CREAMOS ESTE NIVEL
		// creamos Bricks verdes
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("green");
		  l.setX(3+(i * 70) );
		  l.setY(10);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		// creamos Bricks azules
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("blue");
		  l.setX(3+(i * 70) );
		  l.setY(50);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("grey");
		  l.setX(3+(i * 70) );
		  l.setY(90);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("purple");
		  l.setX(3+(i * 70) );
		  l.setY(130);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("red");
		  l.setX(3+(i * 70) );
		  l.setY(170);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("yellow");
		  l.setX(3+(i * 70) );
		  l.setY(210);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		//Inicializamos al jugador
		player = new Player(); 
		player.setX(Arkanoid.WIDTH/2);
		player.setY(Arkanoid.HEIGHT - 2*player.getHeight());
		
		//Inicializamos la bola
		ball= new Ball(); 
		ball.setX(Arkanoid.WIDTH/2);
		ball.setY(Arkanoid.WIDTH/2);
		ball.setVx(3); // velocidad de movimiento lateral
		ball.setVy(3); // velocidad de mov

	}
	
	public void updateWorld() {
		//actuamos las posiciones y estados de los Bricks
		for (int i = 0; i < actors.size(); i++) {
			Actor l = (Actor)actors.get(i);
			l.act();
		}
			ball.act(player.getY(), player.getX());
			player.act();//actuamos, tenemos cosas como comprobar el rebote en su act
		}
	  public void checkCollisions() {
		  Rectangle playerBounds = ball.getBounds();
		  for (int i = 0; i < actors.size(); i++) {
		        Actor a1 = actors.get(i);
		        Rectangle r1 = a1.getBounds();
		        if (r1.intersects(playerBounds)) {
			        ball.vy=-ball.vy;
		        	a1.remove(actors, i);
		       }
		   
		  }
     }
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		Toolkit.getDefaultToolkit().sync(); //toolkit linux ubuntu java
		//fondo
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage( SpriteCache.getInstance().getSprite("background1.jpg"), 0,0, null );
		for (int i = 0; i < actors.size(); i++) {
			Actor l = actors.get(i);
			l.paint(g);
		}
		for (int i = 0; i < explosionlist.size(); i++) {
			Actor exp = explosionlist.get(i);
			exp.paint(g);
		}
		player.paint(g);
		ball.paint(g);
		g.setColor(Color.white);
			if (usedTime > 0) { //contador de fps
				g.drawString(String.valueOf(1000/usedTime)+" fps",0,Arkanoid.HEIGHT-50);
			}else {
				g.drawString("---- fps",0,Arkanoid.HEIGHT-50);
			}
		strategy.show();
	}
	
	
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}
	public void keyTyped(KeyEvent e) {}
	
	public void game() {
		usedTime=1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			checkCollisions();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			try { 
				 Thread.sleep(SPEED);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * @return the explosionlist
	 */
	public List<Actor> getExplosionlist() {
		return explosionlist;
	}

	/**
	 * @param explosionlist the explosionlist to set
	 */
	public void setExplosionlist(List<Actor> explosionlist) {
		this.explosionlist = explosionlist;
	}

	/**
	 * Getter Singleton
	 * @return
	 */
	public static Arkanoid getInstancia () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		//Bucle del juego, creamos un objeto de esta clase misma
		Arkanoid arka = new Arkanoid();
		arka.game();
	
	}
}
