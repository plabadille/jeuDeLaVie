/**
 * A class for representing a Sardine
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish;

import java.util.ArrayList;
import java.util.Map;
import model.gameEngine.GameConstants;
import model.sea.Sea;

public class Sardine extends Fish {

    public Sardine(GameConstants gc, int x, int y) {
        super(gc, x, y);
    }

    @Override
    protected void move(Sea sea) {

        ArrayList<Direction> directionRandomTable;
        directionRandomTable = new ArrayList<Direction>();
        int x = 0, y = 0;
        Direction moveChoice;
        //retrieve neighbourhood
        for (Map.Entry<Direction, Fish> e : sea.getNeighborhood(this).entrySet()) {
            if (e.getValue() == null) {
                directionRandomTable.add(e.getKey());
            }
        }
        moveChoice = randomlyChooseMove(directionRandomTable);
        if (moveChoice != null) {
        	x = coordinateX + moveChoice.getDirectionX();
            y = coordinateY + moveChoice.getDirectionY();
            sea.moveFish(this, x, y);
        } else {
        	System.out.println("The sardine can't move because there's other fish all around");
        }
        
    }

    /**
     * Method which consist of choosing a direction randomly
     * The positions given always led to empty cells.
     * @param d <ArrayList<Direction>> ArrayList of move going to empty cell.
     * @return randomDirection <Direction> The randomly choosen direction
     */
    private Direction randomlyChooseMove(ArrayList<Direction> d) {
        //drawing a lot of direction
        int max = d.size();
        if (max == 0) { //the fish can't move.
        	return null;
        }
        int randomDraw = (int) (Math.random() * (max));
        Direction randomDirection = d.get(randomDraw);
        return randomDirection;

    }

    @Override
    protected void giveBirth(Sea sea){
        super.giveBirth(sea,gameConstants.getSardineSpawnAge(), gameConstants.getSardineSpawnRatio());
    }

    @Override
    public boolean dead(Sea sea) {
        if (this.age > gameConstants.getSardineDeathAge()) {
            sea.deleteFish(this);
            return true;
        }
        return false;
    }

}
