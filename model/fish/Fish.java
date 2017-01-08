/**
 * An abstract class for representing a Fish with coordinate, age, birth control...
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

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
    
    /**
     * Build a new Fish.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     * @param x <int> new x coordinate for the Fish (column)
     * @param y <int> new y coordinate for the Fish (row)
     */
    public Fish(GameConstants gc, int x, int y) {
        this.gameConstants = gc;
        this.coordinateX = x;
        this.coordinateY = y;
        this.age =0;
        this.canGiveBirth = false;
        this.birthCycleCounter = 0;

    }
    
    /**
     * Method used to lauch each action of a Fish in a given order
     * Used by LifeGame for each Fish at each new cycle
     * @param sea <Sea> An instance containing the Sea.
     */
    public void playRound(Sea sea) {
		System.out.println("" + this + " actual coordinate are: x[" + this.getCoordinateX() + "], y[" + this.getCoordinateY() + "]");
        this.giveBirth(sea);
        this.move(sea);
        if (!this.dead(sea)) {
            this.age++;
        }
    }
    
    /**
     * Method used to check if a fish is dead or not. If it's, this method also remove the fish.
     * @param sea <Sea> An instance containing the Sea.
     * @return dead <boolean> True if the Fish is dead, False if it's not.
     */
    protected abstract boolean dead(Sea sea);
    
    /**
     * Method used to move a Fish.
     * @param sea <Sea> An instance containing the Sea.
     */
    protected abstract void move(Sea sea);
    
    /**
     * Method used to call giveBirth(Sea, int, int) by children with them own constants.
     * @param sea <Sea> An instance containing the Sea.
     */
    protected abstract void giveBirth(Sea sea);
    
    /**
     * Method used to give Birth to a new Fish if the condition are checked.
     * The Fish only have a child if there's an available cell around her. If not, it have no child and the have to wait the spawn ratio to have one agin.
     * @param sea <Sea> An instance containing the Sea.
     * @param fishSpawnAge <int> Containing the age when a Fish can have a child.
     * @param fishSpawnRatio <int> Containing the number of cycle needed to have a child again (1 = each cycle).
     */
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
                	if (this instanceof Shark) {
                        sea.createShark(this.getCoordinateX() + key.getDirectionX(), this.getCoordinateY() + key.getDirectionY(), gameConstants);
                	} else {
                        sea.createSardine(this.getCoordinateX() + key.getDirectionX(), this.getCoordinateY() + key.getDirectionY(), gameConstants);
                	}
                    break;
                }
            }
            //If there is no free adjacency slot, the Shark doesn't give birth until next birth cycle.
            this.birthCycleCounter = 0;
            this.canGiveBirth = false;
        }
    }
    
    /**
     * Getter used to get the X coordinate of a Fish
     * @return coordinateX <int> X coordinate of the fish
     */
    public int getCoordinateX() {
        return coordinateX;
    }
    
    /**
     * Getter used to get the Y coordinate of a Fish
     * @return coordinateY <int> Y coordinate of the fish
     */
    public int getCoordinateY() {
        return coordinateY;
    }
    
    /**
     * Setter used to modify the X coordinate of a Fish
     * @param coordinateX <int> X coordinate of the fish
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
    
    /**
     * Setter used to modify the Y coordinate of a Fish
     * @param coordinateY <int> Y coordinate of the fish
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

}
