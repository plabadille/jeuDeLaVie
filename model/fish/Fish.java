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

    public abstract void dead();

    public abstract void move(Sea sea);
    
    public abstract int getCoordinateX();

    public abstract int getCoordinateY();

    public abstract void setCoordinateX(int coordinateX);

    public abstract void setCoordinateY(int coordinateY);
     

}
