package npc;

import java.awt.Graphics;

import engine.Direction;

public interface Npc {
	public void move();
	public boolean checkPlayer();
	public Direction getDirection();
	public void setDirection(Direction direction);
	public int getX();
	public void paint(Graphics g, int additionX, int additionY);
}
