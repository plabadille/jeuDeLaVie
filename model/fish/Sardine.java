package model.fish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.gameEngine.GameConstants;
import model.sea.Sea;

public class Sardine extends Fish {

    public Sardine(GameConstants gc, int x, int y) {
        super(gc, x, y);
    }

    /**
     * Method which consist of moving Sardine randomly
     *
     * @param sea
     */
    @Override
    protected void move(Sea sea) {

        ArrayList<Direction> directionRandomTable;
        directionRandomTable = new ArrayList();
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
        moveChoice = randomSquaresPossible(directionRandomTable);
        System.out.println("Direction tirée au sort : " + moveChoice.name() + " x:[" + moveChoice.getDirectionX() + "] y : [" + moveChoice.getDirectionY() + "]");
        x = coordinateX + moveChoice.getDirectionX();
        y = coordinateY + moveChoice.getDirectionY();
        sea.moveFish(this, x, y);
    }

    /**
     * Method which consist of drawing a lot a direction among the free squares
     *
     * @param d
     * @return a randomDirection
     */
    private Direction randomSquaresPossible(ArrayList<Direction> d) {
        //drawing a lot of direction
        int max = d.size();
        int randomDraw = (int) (Math.random() * (max));
        System.out.println("Tirage au sort : " + randomDraw);
        Direction randomDirection = d.get(randomDraw);
        System.out.println("Direction tirée au sort : " + randomDirection.name() + " x:[" + randomDirection.getDirectionX() + "] y : [" + randomDirection.getDirectionY() + "]");
        return randomDirection;

    }

    /**
     * Method which consit of creating new instance of sardine verifying empty
     * squares in neighbourhood, procreate only in empty square.
     *
     * @param sea
     */
    @Override
    protected void giveBirth(Sea sea){
        super.giveBirth(sea,gameConstants.getSardineSpawnAge(), gameConstants.getSardineSpawnRatio());
    }


    /**
     * Method to remove fish which are dead
     *
     * @param sea
     * @return
     */
    @Override
    public boolean dead(Sea sea) {
        if (this.age > gameConstants.getSardineDeathAge()) {
            sea.deleteFish(this);
            return true;
        }
        return false;
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
