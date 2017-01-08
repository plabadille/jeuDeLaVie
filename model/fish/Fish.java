package model.fish;

import java.util.HashMap;
import model.gameEngine.GameConstants;

import model.sea.Sea;

public abstract class Fish {

    protected GameConstants gameConstants;
    protected int coordinateX;
    protected int coordinateY;
    protected int age;
    protected boolean canGiveBirth;
    protected int birthCycleCounter;

    public Fish(GameConstants gc, int x, int y) {
        this.gameConstants = gc;
        this.coordinateX = x;
        this.coordinateY = y;
        this.age =0;
        this.canGiveBirth = false;
        this.birthCycleCounter = 0;

    }

    //method call by the LifeGame for each Fish each new turn.
    public void playRound(Sea sea) {
        this.giveBirth(sea);
        this.move(sea);
        if (!this.dead(sea)) {
            this.age++;
        }
    }

    protected abstract boolean dead(Sea sea);

    protected abstract void move(Sea sea);
    
    protected abstract void giveBirth(Sea sea);

    protected void giveBirth(Sea sea, int fishSpawnAge, int fishSpawnRatio){
        
        if (this.age > fishSpawnAge) {
            this.birthCycleCounter++;
        }
        if (this.age == fishSpawnAge || this.birthCycleCounter == fishSpawnRatio) {
            this.canGiveBirth = true;
        }
        if (this.canGiveBirth) {
            HashMap<Direction, Fish> neighborhood = sea.getNeighborhood(this);
            //Baby have to spawn in slot next to the mother. If there's none available, they don't spawn.
            for (HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
                Direction key = entry.getKey();
                Fish value = entry.getValue();
                if (value == null) {
                    sea.createShark(this.getCoordinateX() + key.getDirectionX(), this.getCoordinateY() + key.getDirectionY(), gameConstants);
                    break;
                }
            }
            //If there is no free adjacency slot, the Shark doesn't give birth until next birth cycle.
            this.birthCycleCounter = 0;
            this.canGiveBirth = false;
        }
    }

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
