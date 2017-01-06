package model.fish;

import model.gameEngine.GameConstants;
import model.sea.Sea;

public class Sardine extends Fish {

	public Sardine(GameConstants gc, int x, int y) {
		super(gc, x, y);
	}
	
	public void dead() {
		//to do
	}
	@Override
	public void move(Sea sea) {
		//testrécupération des coordonnées
                System.out.println("coordonnées actuelle x :"+coordinateX+"coordonnées actuelle y : "+coordinateY);  
                
                
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