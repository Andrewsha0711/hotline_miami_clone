package player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import engine.Direction;

public class CustomKeyListener implements KeyListener{
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			Player.getInstance().getDirection().setLeft(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			Player.getInstance().getDirection().setRight(true);
		}	
		if (e.getKeyCode()==KeyEvent.VK_W) {
			Player.getInstance().getDirection().setUp(true);
		}	
		if (e.getKeyCode()==KeyEvent.VK_S) {
			Player.getInstance().getDirection().setDown(true);
		}
		if (e.getKeyCode()==KeyEvent.VK_E) {
			Player.getInstance().checkLoot();
		}
//		System.out.println(Player.getInstance().getDirection());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			Player.getInstance().getDirection().setLeft(false);
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			Player.getInstance().getDirection().setRight(false);
		}	
		if (e.getKeyCode()==KeyEvent.VK_W) {
			Player.getInstance().getDirection().setUp(false);
		}	
		if (e.getKeyCode()==KeyEvent.VK_S) {
			Player.getInstance().getDirection().setDown(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
