package model.fish;

public abstract class Fish {
	
	protected int age;
	protected int spawnAge;
	protected int spwanRatio;
	protected int coordinateX;
	protected int coordinateY;
		
	public Fish(int age, int spawnAge, int spawnRatio, int x, int y) {
		this.age = age;
		this.spawnAge = spawnAge;
		this.spwanRatio = spawnRatio;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public abstract void isDead();
	
	public abstract double move();
	
}