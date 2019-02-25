package Arkanoid;

import java.util.List;

import Arkanoid.soundUtils.PlaySound;

public class PowerPill extends Actor {
	protected int vy;
	private int lid=0;
	public PowerPill(int lid) {
		super();
		this.lid=lid;
		this.vy=2;
		if(lid==1) {
			setSpriteNames( new String[] {"heartbox.png"});
		}
		if(lid==2) {
			setSpriteNames( new String[] {"godmode-cut.png"});
		}
		if(lid==3) {
			setSpriteNames( new String[] {"hardenpkm.png"});

		}
		if(lid==4) {
			setSpriteNames( new String[] {"bomb1.png","bomb2.png","bomb3.png","bomb4.png"});
		}
		if(lid==5) {
			setSpriteNames( new String[] {"cursor1.png"});
		}
		setFrameSpeed(8);
	}
	public void act() {
		super.act();
		y+=vy;
	}
	@Override	
    public void removeActor(List<Actor> actors, int i, Player player) {
    		CacheRecursos.getInstancia().playSonido("chirrido-arka.wav");
        	actors.remove(i);
        	Explosion exp = new Explosion();
        	exp.setX(this.getX()+10);
        	exp.setY(this.getY());
        	Arkanoid.getInstance().getAnimationlist().add(exp);
        	PlaySound.getSound().explosionSound();
        	enablePower(lid, player);
    }
	private void enablePower(int lid, Player player) {
		System.out.println("Espada status"+Arkanoid.getInstance().sword);
		if(lid==1) {
			player.lives++;
		}
		if(lid==2) {
			Arkanoid.getInstance().godmode=true;
			Arkanoid.godTime=System.currentTimeMillis();
		}
		if(lid==3) {
			Arkanoid.harderBricks=true;
		}
		if(lid==4) {
			Arkanoid.getInstance().startGameOver();
		}
		if(lid==5) {
			Arkanoid.swordTime=System.currentTimeMillis();
			if(Arkanoid.getInstance().sword==false) {
				Arkanoid.getInstance().sword=true;
	        	Arkanoid.getInstance().animItem.setX(5);
	        	Arkanoid.getInstance().animItem.setY(5);
	        	
			}
			
		}
	}

}
