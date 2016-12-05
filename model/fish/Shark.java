package model.fish;

import model.gameEngine.GameConstants;
import model.fish.behaviour.Context;

public class Shark extends Fish {
    
    private Context context;
    
    public Shark(GameConstants gc, int x, int y) {
        super(gc, x, y);
        this.context = new Context(this.gameConstants);
    }

    @Override
    public void dead() {
        
    }

    @Override
    public void move() {
        this.context.move();
    }
	
    public void eatSardine() {
        //to do
    }
}