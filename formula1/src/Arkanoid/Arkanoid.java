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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	public static List<Actor> explosionlist = new ArrayList<Actor>();
	public static final int WIDTH=701;
	public static final int HEIGHT=750;
	public static final int PLAY_HEIGHT = 670; 
	public static final int SPEED=10;
	public static long initTime=System.currentTimeMillis();
	private static Arkanoid instance = null;
	private boolean pause=false;
	private boolean initPause=true;

	public Arkanoid() {
		
		JFrame ventana = new JFrame("C U S T O M N O I D");
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
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		//SENSOR RATON Botones
		this.addMouseListener( new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				initPause=false;
			}
		});
		//Sensor raton motion
		this.addMouseMotionListener( new MouseMotionAdapter() {
		@Override 
		public void mouseMoved(MouseEvent e) { 
			// TODO Auto-generated method stub
			if(pause) {
				
			}else {
				player.setX(e.getX());
			}
			
		}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_SPACE || e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					pause=!pause;
					initPause=false;
					PlaySound.getSound().blasterSound();
				}
				if(pause) {
					
				}else {
					player.keyPressed(e);
				}
				
			}
		});
	}
	
	public void initWorld() {
	//Creamos los Bricks en arraylist
		//Sonido de fondo
		PlaySound.getSound().background1Sound();
		// CREAMOS ESTE NIVEL
		// creamos Bricks verdes
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("green",1);
		  l.setX(3+(i * 70) );
		  l.setY(10);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		// creamos Bricks azules
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("blue",1);
		  l.setX(3+(i * 70) );
		  l.setY(50);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("grey",1);
		  l.setX(3+(i * 70) );
		  l.setY(90);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("purple",1);
		  l.setX(3+(i * 70) );
		  l.setY(130);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("red",1);
		  l.setX(3+(i * 70) );
		  l.setY(170);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		for (int i = 0; i < 10; i++){
		  Brick l = new Brick("yellow",1);
		  l.setX(3+(i * 70) );
		  l.setY(210);
		  l.setVx((int) (Math.random() * 20-10)); // velocidad de movimiento
		  actors.add(l);
		}
		//Inicializamos al jugador
		player = new Player(); 
		player.setX(Arkanoid.WIDTH/2);
		player.setY(Arkanoid.HEIGHT - 2*player.getHeight()+50);
		
		//Inicializamos la bola
		ball= new Ball(); 
		ball.setX(player.getX()+40);
		ball.setY(player.getY()-128);
		ball.setVx(3); // velocidad de movimiento lateral
		ball.setVy(3); // velocidad de movimiento vertical
		

	}
	
	public void updateWorld() {
		
		// Llamamos al act de cada actor
		for (int i = 0; i < actors.size(); i++) {
			Actor l = actors.get(i);
			l.act();
			
		}
		//Llamamos al act de cada explosion
		for (int i = 0; i < explosionlist.size(); i++) {
			Actor exp = explosionlist.get(i);
			exp.act();
			if(exp.getMarkedForRemoval()>3) { // decidimos cuantas veces queremos repetir la animacion
				explosionlist.clear();
			}
		}
		//que la pelota siga la nave en la pausa inicial
		if(initPause) {
			ball.setX(player.getX()+40);
			ball.setY(player.getY()-20);
		}
		//pausemos la pelota
		if(pause || initPause) {
	
		}else {
			ball.act(player.getY(), player.getX());
		}
		
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
		//Fondo
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage( SpriteCache.getInstance().getSprite("background1.jpg"), 0,0, null );
		//Bucle para pintarse as� mismo cada actor
		for (int i = 0; i < actors.size(); i++) {
			Actor l = actors.get(i);
			l.paint(g);
		}
		//Bucle para pintarse asi mismo cada explosion
		for (int i = 0; i < explosionlist.size(); i++) {
			Actor exp = explosionlist.get(i);
			exp.paint(g);
		}
		//Pintamos la nave y la pelota
		player.paint(g);
		ball.paint(g);
		g.setColor(Color.white);
		if (usedTime > 0) { //contador de fps
			g.drawString(String.valueOf(1000/usedTime)+" fps",0,Arkanoid.HEIGHT-50);
		}else {
			g.drawString("---- fps",0,Arkanoid.HEIGHT-50);
		}// pintar pause
		if(pause || initPause) {
			g.drawImage( SpriteCache.getInstance().getSprite("pause-youtube.png"), Arkanoid.WIDTH/2-255,Arkanoid.HEIGHT/2-280, null );
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
			if(initPause==true && System.currentTimeMillis() - initTime > 5000) {
				initPause=false;
				PlaySound.getSound().blasterSound();

			}
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
	public synchronized static Arkanoid getInstancia () {
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
