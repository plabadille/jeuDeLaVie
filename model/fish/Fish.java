package model.fish;

public abstract class Fish {
	
	protected int deadAge;
	protected int spawnAge;
	protected int spwanRatio;
	protected int coordinateX;
	protected int coordinateY;
		
	public Fish(int age, int spawnAge, int spawnRatio, int x, int y) {
		this.deadAge = age;
		this.spawnAge = spawnAge;
		this.spwanRatio = spawnRatio;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public abstract void dead();
	
	public abstract void move();
	
}