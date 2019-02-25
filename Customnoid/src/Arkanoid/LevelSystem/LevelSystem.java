package Arkanoid.LevelSystem;

import java.util.ArrayList;
import java.util.List;

import Arkanoid.Actor;
import Arkanoid.Arkanoid;
import Arkanoid.Ball;
import Arkanoid.Player;
import Arkanoid.soundUtils.PlaySound;

/**
 * Todas las fases deber�n extender esta clase abstracta y personalizar la apariencia y el comportamiento
 * @author R
 *
 */
public class LevelSystem {
	
	public static void runLevel(List<Actor> actors, Ball ball, Player player){
			Arkanoid.getInstance().initPauseTime=System.currentTimeMillis();
			Arkanoid.getInstance().initPause=true;
			ball.trayectoria = null;
			ball.setVspeed(3);
			ball.setSpriteNames(new String[] {"ballGrey.png"});
			Arkanoid.getInstance().harderBricks=false;
			Arkanoid.getInstance().godmode=false;
			System.out.println("Siguiente fase: "+Arkanoid.getInstance().gamelevel);
			switch (Arkanoid.getInstance().gamelevel) {
				case 1:
					Arkanoid.getInstance().faseActiva=new Fase01();
					Arkanoid.getInstance().faseActiva.inicializaFase();
					actors.addAll(Arkanoid.getInstance().faseActiva.getActores());
					Arkanoid.getInstance().gamelevel++;
					break;
				case 2:
					Arkanoid.getInstance().faseActiva=new Fase02();
					Arkanoid.getInstance().faseActiva.inicializaFase();
					actors.addAll(Arkanoid.getInstance().faseActiva.getActores());
					Arkanoid.getInstance().gamelevel++;
					break;
				case 3:
					Arkanoid.getInstance().faseActiva=new Fase03();
					Arkanoid.getInstance().faseActiva.inicializaFase();
					actors.addAll(Arkanoid.getInstance().faseActiva.getActores());
					ball.setSpriteNames(new String[] {"dogball.png"});
					Arkanoid.getInstance().gamelevel++;
					break;					
				case 4:
					Arkanoid.getInstance().faseActiva=new Fase04();
					Arkanoid.getInstance().faseActiva.inicializaFase();
					actors.addAll(Arkanoid.getInstance().faseActiva.getActores());
					ball.setSpriteNames(new String[] {"ballindepe.png"});
					Arkanoid.getInstance().gamelevel++;
					break;
				case 5:
					Arkanoid.getInstance().faseActiva=new Fase05();
					Arkanoid.getInstance().faseActiva.inicializaFase();
					actors.addAll(Arkanoid.getInstance().faseActiva.getActores());
					Arkanoid.getInstance().gamelevel++;
					break;					
				case 6:
					System.out.println("FIN DEL JUEGO. TODAS LAS FASES ACABADAS");
					Arkanoid.getInstance().pause=true;
					Arkanoid.getInstance().menu=1;
					Arkanoid.getInstance().victory=true;
					actors.add(player);// Lo a�adimos a actores para que no se repita el switch todo el rato mientras esta en victoria
					PlaySound.getSound().stopcustomLoop();
					PlaySound.getSound().customLoop("victoryfree.wav");
					break;
				default:
					Arkanoid.getInstance().gamelevel=6;
					break;
			}
	
	}

}
