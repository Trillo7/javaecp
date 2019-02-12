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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Arkanoid.soundUtils.PlaySound;

public class Arkanoid extends Canvas {
	
	private BufferStrategy strategy;
	private long usedTime;
	private Player player;
	public static Ball ball;
	private List<Actor> actors = new ArrayList<Actor>();
	private List<Actor> explosionlist = new ArrayList<Actor>();
	public static final int WIDTH=701;
	public static final int HEIGHT=750;
	public static final int PLAY_HEIGHT = 670; 
	public static final int SPEED=10;
	public static long initTime=System.currentTimeMillis();
	private int cursorx=0;
	private int cursory=0;
	private boolean pause=false;
	private boolean initPause=true;
	private int menu=1;
	public static boolean gameOver=false;
	boolean esc=false; // para que no active el initPause en el menu si le damos a esc en vez de ser el inicio del juego
	private boolean showFPS=false;
	public static long hitTime=System.currentTimeMillis();
	public static int gamelevel=1;
	// Fase activa en el juego
	Fase faseActiva = null;
	// Variable para patrï¿½n Singleton
	private static Arkanoid instance = null;
	/**
	 * Getter Singleton
	 * @return
	 */
	public synchronized static Arkanoid getInstance () {
		if (instance == null) {
			instance = new Arkanoid();
		}
		return instance;
	}
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
				if(initPause==true && menu==0) { //Para al hacer click en initPause antes de los 5 segundos
					endPausesRoundstart();
				}
				// Boton Jugar
				if(menu==1&&((e.getX()>Arkanoid.WIDTH/2-110)&& (e.getY()>Arkanoid.HEIGHT/2-60 && e.getY()<Arkanoid.HEIGHT/2-15))) { // Quitamos el menu al hacer click en jugar y paramos su mï¿½sica
					menu=0;
					pause=false;
					//Reiniciamos juego si hemos muerto
					if(gameOver) {
						gameOver=false;
						actors.clear();
						Arkanoid.getInstance().initWorld();
					}
					PlaySound.getSound().stopMenu();
				}
				// Boton salir
				if(menu==1&&((e.getX()>Arkanoid.WIDTH/2-70)&& (e.getY()>Arkanoid.HEIGHT/2 && e.getY()<Arkanoid.HEIGHT/2+49))) {
					System.exit(0);
				}
			}
		});
		//Sensor raton motion
		this.addMouseMotionListener( new MouseMotionAdapter() {
		@Override 
		public void mouseMoved(MouseEvent e) { 
			// TODO Auto-generated method stub
			cursorx=e.getX();
			cursory=e.getY();
			if(pause) {
				
			}else {
				player.setX(e.getX()-50);
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
				if(e.getKeyCode()==KeyEvent.VK_SPACE&&menu==0) {
					pause=!pause;
					PlaySound.getSound().blasterSound();
				}
				if(initPause==true && menu==0 && e.getKeyCode()==KeyEvent.VK_SPACE) {
					endPausesRoundstart();
				}
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					menu=1;
					esc=true;
					PlaySound.getSound().blasterSound();
				}
				if(pause) {
					
				}else {
					player.keyPressed(e);
				}
				if(e.getKeyCode()==KeyEvent.VK_CAPS_LOCK) {
					gamelevel=Integer.parseInt(JOptionPane.showInputDialog("TRUCASO. ¿Que nivel quieres acceder?"));
					actors.clear();
				}
			}
		});
	}
	
	public void initWorld() {
		//Creamos los Bricks en arraylist
		PlaySound.getSound().startMenu();
	
		// Agregamos los actores de la primera fase a nuestro juego
		this.actors.clear();
		
		//Inicializamos al jugador
		player = new Player(3); 
		player.setX(Arkanoid.WIDTH/2);
		player.setY(Arkanoid.HEIGHT - 2*player.getHeight()+50);
		
		//Inicializamos la bola
		ball= new Ball(player.getX()+40,player.getY()-130,(float) 2.5);
		
		

	}
	
	public void updateWorld() {
		//INICIO SISTEMA DE NIVELES

		if(actors.isEmpty()) {
			System.out.println("LADRILLOS VACIOS");
			initTime=System.currentTimeMillis();
			initPause=true;
			System.out.println("siguiente fase:"+gamelevel);
			this.ball.trayectoria = null;
			ball.setSpriteNames(new String[] {"ballGrey.png"});
			switch (gamelevel) {
				case 1:
					this.faseActiva=new Fase01();
					this.faseActiva.inicializaFase();
					this.actors.addAll(this.faseActiva.getActores());
					gamelevel++;
					break;
				case 2:
					this.faseActiva=new Fase02();
					this.faseActiva.inicializaFase();
					this.actors.addAll(this.faseActiva.getActores());
					gamelevel++;
					break;
				case 4:
					this.faseActiva=new Fase04();
					this.faseActiva.inicializaFase();
					this.actors.addAll(this.faseActiva.getActores());
					ball.setSpriteNames(new String[] {"ballindepe.png"});
					gamelevel++;
					break;
				default:
					System.out.println("FIN DEL JUEGO. TODAS LAS FASES ACABADAS");
					gameOver=true;
					menu=1;
					break;
			}
			
		}
		//FIN SISTEMA DE NIVELES
		// Que la pelota siga a la nave en la pausa inicial
		if(initPause) {
		//	System.out.println("COLOCAMOS BOLA EN LA NAVE");
			ball.setX(player.getX()+40);
			ball.setY(player.getY()-24);
		}
		// Para que no cuente los segundos en el menu
		if(menu==1) {
			initTime=System.currentTimeMillis();
		}
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

		// Pausemos la pelota
		if(pause || initPause) {
	
		}else {
			ball.act(player.getY(), player.getX());
		}
		// Cuando el menu es el inicio del juego activamos initpause, si no solo pause ya que es el menu de escapada
		if(menu==1 && esc==false) {
			initPause=true;
		}else if(menu==1&&esc) {
			pause=true;
		}
		//actuamos la nave
		player.act();
	}
	public void checkCollisions() {
		Rectangle ballRect = ball.getBounds();
		for (int i = 0; i < actors.size(); i++) {
			Actor a1 = actors.get(i);
			Rectangle r1 = a1.getBounds();
		    if (r1.intersects(ballRect)) {
		    	Rectangle superiorrect=new Rectangle(a1.getX(),a1.getY(),a1.getWidth(),2);
		    	Rectangle inferiorrect=new Rectangle(a1.getX(),a1.getY()+22,a1.getWidth(),2);
		  
		    	ball.collisioned();
		        a1.remove(actors, i);
		        break;
		    }
		}
	}
	public void paintWorld() {
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		Toolkit.getDefaultToolkit().sync(); //toolkit linux ubuntu java
		//Fondo
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage( SpriteCache.getInstance().getSprite(this.faseActiva.getBackgroundImg()), 0,0, null );
		//Bucle para pintarse asï¿½ mismo cada actor
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
		//contador de fps
		if(showFPS) {
			if (usedTime > 0) { 
				g.drawString(String.valueOf(1000/usedTime)+" fps",0,Arkanoid.HEIGHT-50);
			}else {
				g.drawString("---- fps",0,Arkanoid.HEIGHT-50);
			}
		}
		// pintar pause
		if(pause || initPause || menu==1) {
			g.drawImage( SpriteCache.getInstance().getSprite("logo-customnoid-tr75.png"), 10,Arkanoid.HEIGHT/2-360, null );
			g.drawImage( SpriteCache.getInstance().getSprite("gnome-pause.png"), Arkanoid.WIDTH/2-255,Arkanoid.HEIGHT/2-280, null );
		}
		// Pintamos menu
		if(menu==1) {
			g.drawImage( SpriteCache.getInstance().getSprite("background2.png"), 0,0, null );
			g.drawImage( SpriteCache.getInstance().getSprite("background2-test.jpg"), 0,0, null );
			g.drawImage( SpriteCache.getInstance().getSprite("insert-coin.png"), Arkanoid.WIDTH-200,Arkanoid.HEIGHT/2+200, null );
			g.drawImage( SpriteCache.getInstance().getSprite("logotrillostudios-75.png"), 50,Arkanoid.HEIGHT/2+200, null );
			if(gameOver) {
				g.drawImage( SpriteCache.getInstance().getSprite("goverbg2.jpg"), -150,0, null );
				//g.drawImage( SpriteCache.getInstance().getSprite("game-over.png"), Arkanoid.WIDTH/2-195,Arkanoid.HEIGHT/2-370, null );
			}
			g.drawImage( SpriteCache.getInstance().getSprite("logo-customnoid-tr-50.png"), Arkanoid.WIDTH/2-195,Arkanoid.HEIGHT/2-370, null );
			g.drawImage( SpriteCache.getInstance().getSprite("yellow_button00.png"), Arkanoid.WIDTH/2-110,Arkanoid.HEIGHT/2-60, null );
			g.drawImage( SpriteCache.getInstance().getSprite("red_button00.png"), Arkanoid.WIDTH/2-110,Arkanoid.HEIGHT/2, null );
			//pintamos cursor
			g.drawImage( SpriteCache.getInstance().getSprite("cursor1.png"), cursorx-11,cursory-40, null );
		}
		strategy.show();
		
	}
	
	public void endPausesRoundstart() {
		initPause=false;
		pause=false;
		CacheRecursos.getInstancia().loopSonido(this.faseActiva.getGameplaySound());
		PlaySound.getSound().blasterSound();

	}
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
			if(initPause==true && menu==0 && System.currentTimeMillis() - initTime > 5000) {
				endPausesRoundstart();

			}
			if(System.currentTimeMillis()-hitTime>170) { // para que la nave cambie de color al rebotar
				Player.hit=false;
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

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}
	
	public static void main(String[] args) {
		//Bucle del juego, creamos un objeto de esta clase misma
		CacheRecursos.getInstancia().cargarRecursosEnMemoria();
		Arkanoid.getInstance().game();
	}
}
