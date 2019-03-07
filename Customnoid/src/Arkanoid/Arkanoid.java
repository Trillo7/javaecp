package Arkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import Arkanoid.LevelSystem.Fase;
import Arkanoid.LevelSystem.LevelSystem;
import Arkanoid.soundUtils.PlaySound;

public class Arkanoid extends Canvas {
	
	private BufferStrategy strategy;
	private long usedTime;
	// Ventana
	JFrame ventana = null;
	private Player player;
	public static Ball ball;
	private List<Actor> actors = new ArrayList<Actor>();
	private List<Actor> animationList = new ArrayList<Actor>();
	animatedItem animItem = new animatedItem();
	public static final int WIDTH=690;
	public static final int HEIGHT=750;
	public static final int PLAY_HEIGHT = 640; 
	public static final int SPEED=10;
	public static long initPauseTime=System.currentTimeMillis();
	private int cursorx=0;
	private int cursory=0;
	boolean mouseInPlay=false;
	boolean mouseInExit=false;
	public boolean pause=false;
	public boolean initPause=true;
	public int menu=1;
	public boolean victory=false;
	public static boolean gameOver=false;
	boolean esc=false; // para que no active el initPause en el menu si le damos a esc en vez de ser el inicio del juego
	private boolean showFPS=false;
	public static long hitTime=System.currentTimeMillis();
	public static long godTime=System.currentTimeMillis();
	public static long swordTime=System.currentTimeMillis();
	public static int gamelevel=1;
	public boolean godmode=false;
	public boolean sword=false;
	int swordPointer=0;
	public static boolean harderBricks=false;
	// Fase activa en el juego
	public Fase faseActiva = null;
	// Variable para patr�n Singleton
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
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeApplication();
			}
		});
		// Con ignoreRepaint le decimos al JFrame que no debe repintarse cuando el Sistema Operativo se lo indique,
		// nosotros nos ocupamos totalmente del refresco de la pantalla
		ventana.setIgnoreRepaint(true);
		// La ventana no podr� redimensionarse
		ventana.setResizable(false);
		// Hacemos que el Canvas obtenga autom�ticamente el foco del programa para que, si se pulsa una tecla, la pulsaci�n
		// se transmita directamente al Canvas.
		this.requestFocus();
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		animationList.add(animItem);
		//SENSOR RATON Botones
		this.addMouseListener( new MouseAdapter() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {	}
			
			@Override 
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(initPause==true && menu==0) { //Para al hacer click en initPause antes de los 5 segundos
					endPausesRoundstart();
				}
				// Boton Jugar
				if(menu==1&&(mouseInPlay)) { // Quitamos el menu al hacer click en jugar y paramos su m�sica
					menu=0;
					pause=false;
					//Reiniciamos juego si hemos muerto
					if(gameOver) {
						gameOver=false;
						actors.clear();
						PlaySound.getSound().background3Stop();
						player.lives=3;
						System.out.println("reiniciamos nivel");
						gamelevel=1;
					}
					if(!esc) { // paramos el sonido solo si no le damos a escapada, si no para la musica de fondo por error
						PlaySound.getSound().stopMenu();

					}
				}
				// Boton salir
				if(menu==1&&(mouseInExit)) {
					System.exit(0);
				}
			}
		});
		// INICIO LISTENERS
		this.addMouseMotionListener( new MouseMotionAdapter() {
		@Override 
		public void mouseMoved(MouseEvent e) { 
			// TODO Auto-generated method stub
			if(menu==1) {
				cursorx=e.getX();
				cursory=e.getY();
			}
			if(pause) {
				
			}else {
				player.setX(e.getX()-50);
			}
			// Si el raton esta encima del play
			if(menu==1&&(((e.getX()>Arkanoid.WIDTH/2-110))&& (e.getY()>Arkanoid.HEIGHT/2-44 && e.getY()<Arkanoid.HEIGHT/2+15))) { // Quitamos el menu al hacer click en jugar y paramos su m�sica
				mouseInPlay=true;
			}else {
				mouseInPlay=false;
			}
			// Si el raton esta encima del exit
			if(menu==1&&((e.getX()>Arkanoid.WIDTH/2-70)&& (e.getY()>Arkanoid.HEIGHT/2+15 && e.getY()<Arkanoid.HEIGHT/2+80))) {
				mouseInExit=true;
			}else {
				mouseInExit=false;
			}
			if(sword) {
				animationList.get(0).setX(e.getX());
				animationList.get(0).setY(e.getY());
			}
		}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override public void keyTyped(KeyEvent e) {}
			
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
				if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
					gamelevel=Integer.parseInt(JOptionPane.showInputDialog("TRUCASO. �Que nivel quieres acceder?"));
					actors.clear();
				}
			}
		});
		// FIN LISTENERS
		// FIN ARKANOID BUILDER
	}

	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void closeApplication() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"�Desea cerrar la aplicaci�n?","Salir de la aplicaci�n",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
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
		ball= new Ball(player.getX()+40,player.getY()-130,(float) 2.5f);
	}
	
	public void updateWorld() {
		// INICIO SISTEMA DE NIVELES
		if(actors.isEmpty()) {
			LevelSystem.runLevel(actors, ball, player);
		}
		//FIN SISTEMA DE NIVELES
		// Que la pelota siga a la nave en la pausa inicial
		if(initPause) {
			ball.setX(player.getX()+40);
			ball.setY(player.getY()-24);
		}
		// Para que no cuente los segundos en el menu si no initpause lo quita al instante en game()
		if(menu==1) {
			initPauseTime=System.currentTimeMillis();
		}
		// Llamamos al act de cada actor
		for (int i = 0; i < actors.size(); i++) {
			Actor l = actors.get(i);
			l.act();
		}
		// Ponemos harder a 0 para que no les ponga siempre 2 vidas
		harderBricks=false;
		// Limpiamos los actores cuando solo quedan bloques irrompibles
		if(actors.size()==this.faseActiva.numIrrompibles) {
			actors.clear();
		}
		//Llamamos al act de cada explosion y para que se reproduzca su animacion
		for (int i = 0; i < animationList.size(); i++) {
			if(animationList.get(i) instanceof Explosion) {
				Explosion exp = (Explosion) animationList.get(i);
				exp.act();
				if(exp.getMarkedForRemoval()>exp.getAnimRepeat()) { // decidimos cuantas veces queremos repetir la animacion
					animationList.remove(i);
				}
			}else {
				animatedItem animationItemac=(animatedItem) animationList.get(0);
				animationItemac.act();
			}

		}
		// Pausemos la pelota
		if(pause || initPause) {
	
		}else {
			ball.act(player);
		}
		// Cuando el menu es el inicio del juego activamos initpause, si no solo pause ya que es el menu de escapada
		if(menu==1 && esc==false) {
			initPause=true;
		}else if(menu==1&&esc) {
			pause=true;
		}
		// Actuamos la nave
		player.act();
	}
	public void checkCollisions() {
		Rectangle ballRect = ball.getBounds();
		for (int i = 0; i < actors.size(); i++) {
			Actor a1 = actors.get(i);
			Rectangle r1 = a1.getBounds();
			if(a1 instanceof PowerPill) {
				// Si es una pildora Colisionamos con nave
				Rectangle playerRect=player.getBounds();
				if(r1.intersects(playerRect)) {
			        a1.removeActor(actors, i,player); // Para todos los efectos de eliminar la pildora y llamar a sus efectos
				}
				// Eliminamos pildora si se pasa de la y
				if(a1.y>Arkanoid.getInstance().getHeight()) {
					actors.remove(i);
				}
			}else {
			    if (r1.intersects(ballRect)) {
			    	// Rectangles de ladrillos (Detector de lado golpeado)
			    	String hitSide=null;
			    	Rectangle superiorrect=new Rectangle(a1.getX(),a1.getY(),a1.getWidth(),1);
			    	Rectangle inferiorrect=new Rectangle(a1.getX(),a1.getY()+a1.getHeight(),a1.getWidth()+2,1);
			    	Rectangle izqrect=new Rectangle(a1.getX(),a1.getY(),1,a1.getHeight());
			    	Rectangle derrect=new Rectangle(a1.getX()+a1.getWidth(),a1.getY(),1,a1.getHeight());
			    	if(ballRect.intersects(superiorrect)) {
			    		hitSide="sup";
			    	}else if(ballRect.intersects(derrect)) {
			    		hitSide="der";
			    	}else if(ballRect.intersects(izqrect)) {
			    		hitSide="izq";
			    	}else if(ballRect.intersects(inferiorrect)) {
			    		hitSide="inf";
			    	}
			    	ball.collisioned(hitSide); // Para el rebote
			        a1.removeActor(actors, i,player); // Para todos los efectos de eliminar(vidas, generar pildora etc)
			        break;
			    }
			}
			// Comprobamos si tenemos el poder sword
			if(sword) {
		    	Rectangle mouseRect=animationList.get(0).getBounds();

				if(ballRect.intersects(mouseRect)) {
					System.out.println("REBOTAR");
					String hitSide=null;
					hitSide="sup";
					ball.collisioned(hitSide);
				}
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
		g.drawImage( SpriteCache.getInstance().getSprite(this.faseActiva.getBackgroundImg()), 0,0, null );
		// Fondo godmode
		if(godmode) {
			g.drawImage( SpriteCache.getInstance().getSprite("godmode-background.png"), 50,0, null );
		}
		//Bucle para pintarse as� mismo cada actor
		for (int i = 0; i < actors.size(); i++) {
			Actor l = actors.get(i);
			l.paint(g);
		}
		//Bucle para pintarse asi mismo cada explosion
		for (int i = 0; i < animationList.size(); i++) {
			if(animationList.get(i) instanceof Explosion) {
				Actor exp=animationList.get(i);
				exp.paint(g);
			}else {
				if(sword) {
					animatedItem animationItem = (animatedItem) animationList.get(i);
					animationItem.paint(g);	
				}
		
			}

		}
		//Pintamos la nave y la pelota
		player.paint(g);
		ball.paint(g);
		g.setColor(Color.white);
		// Contador de fps
		if(showFPS) {
			if (usedTime > 0) { 
				g.drawString(String.valueOf(1000/usedTime)+" fps",0,Arkanoid.HEIGHT-50);
			}else {
				g.drawString("---- fps",0,Arkanoid.HEIGHT-50);
			}
		}
		// Barra de estadisticas
		Font myFont = new Font ("Segoe UI", 1, 27);
		g.setFont (myFont);
		// Vidas
		g.drawImage( SpriteCache.getInstance().getSprite("livesbox-cut.png"), 10,this.HEIGHT-107, null );
		// Si estamos en godmode dibujamos los segundos en vez de las vidas
		if(godmode||sword) {
			if(godmode) {
				g.drawString (""+(15-(System.currentTimeMillis()-godTime)/1000), 135,this.HEIGHT-60);

			}else {
				g.drawString (""+(10-(System.currentTimeMillis()-swordTime)/1000), 135,this.HEIGHT-60);
			}
		}else {
			g.drawString (""+player.lives, 135,this.HEIGHT-60);
		}
		// Puntuacion
		g.drawImage( SpriteCache.getInstance().getSprite("urscore-cut.png"), 260,this.HEIGHT-103, null );
		g.drawString (""+player.myscore, 310,this.HEIGHT-60);
		// Fase
		g.drawImage( SpriteCache.getInstance().getSprite("level-cut.png"), this.WIDTH-235,this.HEIGHT-100, null );
		g.drawString (""+(gamelevel-1), this.WIDTH-55,this.HEIGHT-67);


		// Pintar pause
		if(pause || initPause) {
			//Logos ESQUINAS
			g.drawImage( SpriteCache.getInstance().getSprite("newcustomnoid-75.png"), 10,Arkanoid.HEIGHT/2-360, null );
			g.drawImage( SpriteCache.getInstance().getSprite("gnome-pause.png"), Arkanoid.WIDTH/2-255,Arkanoid.HEIGHT/2-280, null );
		}
		// Pintamos menu
		if(menu==1) {
			g.drawImage( SpriteCache.getInstance().getSprite("background2-original.png"), -620,-180, null );
			g.drawImage( SpriteCache.getInstance().getSprite("insert-coin.png"), Arkanoid.WIDTH-200,Arkanoid.HEIGHT/2+200, null );
			g.drawImage( SpriteCache.getInstance().getSprite("logotrillostudios-75.png"), 50,Arkanoid.HEIGHT/2+200, null );
			if(gameOver) {
				g.drawImage( SpriteCache.getInstance().getSprite("gameover2bg.png"), -150,0, null );
				g.drawImage( SpriteCache.getInstance().getSprite("logo-customnoid-tr-50.png"), Arkanoid.WIDTH/2-195,Arkanoid.HEIGHT/2-370, null );
			}else {
				g.drawImage( SpriteCache.getInstance().getSprite("newcustomnoid-50.png"), Arkanoid.WIDTH/2-185,Arkanoid.HEIGHT/2-370, null );
			}
			// Si el juego ha acabado game over no mostramos el botond de Play, y a�adimos efecto de un boton u otra si pasamos el raton por el boton
			if(!mouseInPlay) {
				g.drawImage( SpriteCache.getInstance().getSprite("play-squarebutton.png"), Arkanoid.WIDTH/2-130,Arkanoid.HEIGHT/2-44, null );

			}else {
				g.drawImage( SpriteCache.getInstance().getSprite("playbutton-2.png"), Arkanoid.WIDTH/2-130,Arkanoid.HEIGHT/2-44, null );

			}
			if(!mouseInExit) {
				g.drawImage( SpriteCache.getInstance().getSprite("red_button00.png"), Arkanoid.WIDTH/2-130,Arkanoid.HEIGHT/2+25, null );

			}else {
				g.drawImage( SpriteCache.getInstance().getSprite("red_button02.png"), Arkanoid.WIDTH/2-130,Arkanoid.HEIGHT/2+25, null );
			}			
			// Pintamos pantalla de victoria
			if(victory) {
				g.drawImage( SpriteCache.getInstance().getSprite("victorybg.jpg"), -100,0, null );
				
			}
			// Pintamos cursor
			g.drawImage( SpriteCache.getInstance().getSprite("cursor2-cut.png"), cursorx-25,cursory-20, null );
		}

		strategy.show();
		
	}
	
	public void startGameOver() {
		System.out.println("llamamos a gameover");
		Arkanoid.getInstance().setMenu(1);
		Arkanoid.gameOver=true;
		gamelevel=-1;
		PlaySound.getSound().startSound("long-bowser.wav");
		PlaySound.getSound().stopcustomLoop();
		PlaySound.getSound().customLoop("creepy1.wav");

	}
	public void endPausesRoundstart() {
		initPause=false;
		pause=false;
		PlaySound.getSound().stopcustomLoop();
		PlaySound.getSound().blasterSound();
		PlaySound.getSound().stopcustomLoop();
		PlaySound.getSound().customLoop(faseActiva.getGameplaySound());
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
			
			if(initPause==true && menu==0 && System.currentTimeMillis() - initPauseTime > 5000) {
				endPausesRoundstart();
			}
			// Para que la nave cambie de color al rebotar (realizado en la clase ball)
			if(System.currentTimeMillis()-hitTime>170) { 
				Player.hit=false;
			}
			// Para que acabe el god mode al pasar el tiempo
			if(System.currentTimeMillis()-godTime>15500) { 
				godmode=false;
			}
			// Para que acabe el sword mode al pasar el tiempo
			if(System.currentTimeMillis()-swordTime>10000) { 
				sword=false;
			}
		}
	}
	
	/**
	 * @return the explosionlist
	 */
	public List<Actor> getAnimationlist() {
		return animationList;
	}

	/**
	 * @param explosionlist the explosionlist to set
	 */
	public void setExplosionlist(List<Actor> explosionlist) {
		this.animationList = explosionlist;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}
	
	public boolean isInitPause() {
		return initPause;
	}
	public void setInitPause(boolean initPause) {
		this.initPause = initPause;
	}
	public static void main(String[] args) {
		//Bucle del juego, creamos un objeto de esta clase misma
		CacheRecursos.getInstancia().cargarRecursosEnMemoria();
		Arkanoid.getInstance().game();
	}
}
