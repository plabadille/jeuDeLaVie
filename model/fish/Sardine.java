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
        //testrécupération des coordonnées
        System.out.println("coordonnées actuelle x :" + coordinateX + "coordonnées actuelle y : " + coordinateY + " Ma ref : " + getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)));
        //retrieve neighbourhood
        System.out.println("voisin de l'instance en cours : " + sea.getNeighborhood(this));
        for (Map.Entry<Direction, Fish> e : sea.getNeighborhood(this).entrySet()) {
            //Display Hashmap values of Sardine
            if (e.getValue() == null) {
                System.out.println("[" + e.getKey() + "] -> " + e.getValue());
                directionRandomTable.add(e.getKey());
            }
        }
        moveChoice = randomlyChooseMove(directionRandomTable);
        System.out.println("Direction tirée au sort : " + moveChoice.name() + " x:[" + moveChoice.getDirectionX() + "] y : [" + moveChoice.getDirectionY() + "]");
        x = coordinateX + moveChoice.getDirectionX();
        y = coordinateY + moveChoice.getDirectionY();
        sea.moveFish(this, x, y);
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
        int randomDraw = (int) (Math.random() * (max));
        System.out.println("Tirage au sort : " + randomDraw);
        Direction randomDirection = d.get(randomDraw);
        System.out.println("Direction tirée au sort : " + randomDirection.name() + " x:[" + randomDirection.getDirectionX() + "] y : [" + randomDirection.getDirectionY() + "]");
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
