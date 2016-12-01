package model.fish;

public abstract class Fish {
	
	protected int deathAge;
	protected int spawnAge;
	protected int spwanRatio;
	protected int coordinateX;
	protected int coordinateY;
		
	public Fish(int deathAge, int spawnAge, int spawnRatio, int x, int y) {
		this.deathAge = deathAge;
		this.spawnAge = spawnAge;
		this.spwanRatio = spawnRatio;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public abstract void dead();
	
	public abstract void move();
	
}