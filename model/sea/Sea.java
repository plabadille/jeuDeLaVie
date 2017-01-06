
package model.sea;

import java.util.ArrayList;

import model.fish.*;
import model.gameEngine.GameConstants;
import model.sea.populate.*;

public class Sea {
	//TO DO Une méthode voisinage par exemple pourrait renvoyer un tableau de 8 cases par exemple
	private int length;
    private int width;
    private Fish [][] sea ;
    private ArrayList<Fish> fishAlive;
        
    public Sea(GameConstants gc) {
    	
        this.length = gc.getSeaLenght();
        this.width = gc.getSeaWidth();
        
        this.sea = new Fish[width][length];
        this.fishAlive = new ArrayList<Fish>();
        
        populateSea(gc);
        
        for(int x = 0; x < this.length; x++) {
        	for(int y = 0; y < this.width; y++) {
        		if (sea[x][y] != null) {
        			this.fishAlive.add(sea[x][y]);
        		}
        	}
        }

    }
    
    private void populateSea(GameConstants gc) {
    	
    	int seaSize = this.length * this.width;
    	int fishNb = gc.getSeaSharkNumber() + gc.getSeaSardineNumber();
    	float populationRate = fishNb / seaSize;
    	
    	IStrategyPopulate strategy;
    	if (populationRate > 0 && populationRate <= 0.2) {
    		strategy = new RandomStrategy();
    	} else if (populationRate > 0.2 && populationRate <= 0.4) {
    		strategy = new FreeCellRandom();
    	} else {
    		strategy = new PermutationRandom();
    	}
    	
    	Context context = new Context(strategy);
    	
    	this.sea = context.executeStrategy(gc, this.sea);
    	
    }

	public Fish[][] getSea() {
		return sea;
	}

	public void setSea(Fish[][] sea) {
		this.sea = sea;
	}

	public ArrayList<Fish> getFishAlive() {
		return fishAlive;
	}

	public void setFishAlive(ArrayList<Fish> fishAlive) {
		this.fishAlive = fishAlive;
	}
	
	
    
}

