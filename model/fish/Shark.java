/**
 * A class for representing a Shark
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish;

import model.gameEngine.GameConstants;

import java.util.ArrayList;
import java.util.HashMap;

import model.fish.behaviour.Context;
import model.sea.Sea;

public class Shark extends Fish {

    private Context context;
    private int starvingTime;
    
    public Shark(GameConstants gc, int x, int y) {
        super(gc, x, y);
        this.context = new Context(this.gameConstants);
        this.starvingTime = gc.getSharkStarvingTime();
    }

    @Override
    protected void giveBirth(Sea sea){
        super.giveBirth(sea,gameConstants.getSharkSpawnAge(), gameConstants.getSharkSpawnRatio());
    }

    protected boolean dead(Sea sea) {
        if (this.starvingTime < 0 || this.age > gameConstants.getSharkDeathAge()) {
            sea.deleteFish(this);
            return true;
        }
        return false;
    }

    @Override
    protected void move(Sea sea) {
        this.context.move(sea, this);
    }
    
    /**
     * Method used by shark State in some case but in different strategy to do a random move.
     * @param sea <Sea> An instance containing the Sea.
     */
    public void randomMove(Sea sea) {
        HashMap<Direction, Fish> neighborhood = sea.getNeighborhood(this);
        ArrayList<Direction> directionRandomTable = new ArrayList<Direction>();
        ArrayList<Fish> fishRandomTable = new ArrayList<Fish>();

        //first we check the possible move and store them into an array of Direction
        for (HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
            Direction key = entry.getKey();
            Fish value = entry.getValue();

            if (!(value instanceof Shark)) {
                directionRandomTable.add(key);
                fishRandomTable.add(value);
            }
        }

        //second we select randomly one move
        int random = (int) (Math.random() * directionRandomTable.size());
        int x = directionRandomTable.get(random).getDirectionX() + this.getCoordinateX();
        int y = directionRandomTable.get(random).getDirectionY() + this.getCoordinateY();
        Fish fish = fishRandomTable.get(random);

        //then we check if there's something to eat and do the move.
        if (fish == null) {
            this.starve();
            sea.moveFish(this, x, y);
        } else {
            this.eat(fish, sea);
            sea.moveFish(this, x, y);
        }
    }
    
    /**
     * Method used when a Shark eat a Sardine
     * Call by move() or randomMove()
     * @param sardine <Fish> Containing the instance of the Sardine going to be eaten
     * @param sea <Sea> An instance containing the Sea.
     */
    public void eat(Fish sardine, Sea sea) {
        if (sardine != null) {
            this.starvingTime = gameConstants.getSharkStarvingTime();
            sea.deleteFish(sardine);
        }
    }
    
    /**
     * Method used when a Shark doesn't eat a Sardine (move into an empty cell)
     * Call by move() or randomMove()
     */
    public void starve() {
        this.starvingTime--;
    }

}
