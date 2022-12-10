package npc;

import java.util.Random;

import engine.Direction;
import game.GameWindow;

public class SecurityGuardThread extends Thread{
	public static boolean isRunning = false;
	private Npc npc;
	Random random;
	
	public SecurityGuardThread(Npc npc) {
		if(npc instanceof Proxy || npc instanceof SecurityGuard) {
			this.npc = npc;
		}
		this.random = new Random();
	}
	
	private boolean isStanding() {
		return(!(this.npc.getDirection().left ||
				this.npc.getDirection().right ||
				this.npc.getDirection().down ||
				this.npc.getDirection().up));
	}
	
	private void getRandomDirection() {
		this.npc.getDirection().setLeft(this.random.nextBoolean());
		this.npc.getDirection().setRight(this.random.nextBoolean());
		this.npc.getDirection().setDown(this.random.nextBoolean());
		this.npc.getDirection().setUp(this.random.nextBoolean());
	}
	
	public void run() {
		isRunning = true;
		int actionTime = 5;
		while (isRunning) {
			try {
				if(actionTime > 0) {
					this.npc.move();
					actionTime--;
				}
				else {
					this.getRandomDirection();
					actionTime = 50;
				}
				sleep(100);
//				GameWindow.getInstance().repaint();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
