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
    public void dead() {
        //to do
    }

    /**
     * Method which consist of moving Sardine randomly
     *
     * @param sea
     */
    @Override
    public void move(Sea sea) {
        
        ArrayList<Direction> directionRandomTable;
        directionRandomTable = new ArrayList();
        int i =0;
        //testrécupération des coordonnées
        System.out.println("coordonnées actuelle x :" + coordinateX + "coordonnées actuelle y : " + coordinateY + " Ma ref : "+getClass().getName()+"@"+Integer.toHexString(System.identityHashCode(this)));
            
            //retrieve neighbourhood
            System.out.println("voisin de l'instance en cours : "+sea.getNeighborhood(this));
                for(Map.Entry <Direction, Fish> e : sea.getNeighborhood(this).entrySet()){
                    //Display Hashmap values of Sardine
                    
                    if (e.getValue() == null) {
                        System.out.println("["+e.getKey()+"] -> "+e.getValue());
                        directionRandomTable.add(e.getKey());
                        //System.out.println("ligne du tableau "+i+" : "+directionRandomTable.get(i));
                        }  
                    i++;
                
            }
                
             System.out.println("i :" +i);
                

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
