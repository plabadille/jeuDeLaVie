package model.fish;

import model.gameEngine.GameConstants;
import model.fish.behaviour.Context;
import model.sea.Sea;

public class Shark extends Fish 
{
    
    private Context context;
    
    public Shark(GameConstants gc, int x, int y) {
        super(gc, x, y);
        this.context = new Context(this.gameConstants);
    }

    @Override
    public void dead() {
        
    }

    @Override
    public void move(Sea sea) {
        this.context.move(sea, this);
    }
	
    public void eatSardine() {
        //to do
    }
    
    //getter & setter

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