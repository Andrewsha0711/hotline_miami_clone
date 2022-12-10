package npc;

import java.awt.Graphics;
import java.awt.Graphics2D;

import engine.MovingObject;
import engine.RectArea;
import player.Player;

public class Proxy extends MovingObject implements Npc{
	// Для определения видимости
    public static final int DEF_Width = 1280;
    public static final int DEF_Height = 720;
	
    //Шаг при ходьбе
    private int defaultStep = 2;
	private SecurityGuard npc;
	
    private boolean flag = false;
	
	public Proxy(int x, int y, RectArea area) {
		super(x, y, 53 ,53);
		this.setArea(area);
	}
	
	public boolean isVisible() {
		return (this.getX() > Player.getInstance().getX() - DEF_Width/2 &&
				this.getX() < Player.getInstance().getX() + DEF_Width/2 &&
				this.getY() > Player.getInstance().getY() - DEF_Height/2 &&
				this.getY() < Player.getInstance().getY() + DEF_Height/2);
	}
	
	@Override
	public void move() {
		// TODO: обрубается checkPlayer
		super.move(defaultStep);
		if(this.isVisible()) {
			if(this.npc == null) {
				this.npc = new SecurityGuard(this.getX(), this.getY(), this.getArea());
			}
			this.npc.setDirection(this.getDirection());
			this.npc.setX(this.getX());
			this.npc.setY(this.getY());
		}
	}
	
//	public void move() {
//		// TODO: обрубается checkPlayer
//		if(this.isVisible()) {
//			if(this.npc == null) {
//				this.npc = new SecurityGuard(this.getX(), this.getY(), this.getArea());
//			}
//			if(!flag) {
//				this.npc.setDirection(this.getDirection());
//				this.npc.setX(this.getX());
//				this.npc.setY(this.getY());
//			}
//			this.npc.move();
//			flag = true;
//		}
//		else {
//			if(flag) {
//				this.setDirection(this.npc.getDirection());
//				this.setX(this.npc.getX());
//				this.setY(this.npc.getY());
//			}
//			super.move(defaultStep);
//			flag = false;
//		}
//	}
	

	@Override
	public boolean checkPlayer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paint(Graphics g, int additionX, int additionY) {
		if(this.isVisible()) {
			if(this.npc == null) {
				this.npc = new SecurityGuard(this.getX(), this.getY(), this.getArea());
			}
			this.npc.paint(g, additionX, additionY);
		}
	}
	
	
}
