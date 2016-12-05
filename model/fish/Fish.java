package model.fish;

import model.gameEngine.GameConstants;

public abstract class Fish {
	
	protected GameConstants gameConstants;
	protected int coordinateX;
	protected int coordinateY;
		
	public Fish(GameConstants gc, int x, int y) {
		this.gameConstants = gc;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public abstract void dead();
	
	public abstract void move();
	
}
