package Arkanoid;

public class DestroyBrick implements ListenerBrick {

	@Override
	public void DestroyBrick(BrickEvent evento) {
		// TODO Auto-generated method stub
		System.out.println("Ladrillo destruido: "+evento.brick.lid);
		System.out.println("Guardado en la BBDD");
	}

}
