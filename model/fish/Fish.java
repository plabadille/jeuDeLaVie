package model.fish;

import model.gameEngine.GameConstants;

import model.sea.Sea;

public abstract class Fish {

    protected GameConstants gameConstants;
    protected int coordinateX;
    protected int coordinateY;
    protected int birth = 0;
    protected int[][] neighborsSquares;

    public Fish(GameConstants gc, int x, int y) {
        this.gameConstants = gc;
        this.coordinateX = x;
        this.coordinateY = y;

    }
    
    //method call by the LifeGame for each Fish each new turn.
    public void playRound(Sea sea) {
    	this.giveBirth(sea);
    	this.move(sea);
    	boolean alive = this.dead(sea);
    	if (alive) {
    		this.birth++;
    	}
    }

    protected abstract boolean dead(Sea sea);

    protected abstract void move(Sea sea);
    
    protected abstract void giveBirth(Sea sea);
    
    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
}
