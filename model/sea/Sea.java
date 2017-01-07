
package model.sea;

import java.util.ArrayList;
import java.util.HashMap;

import model.fish.*;
import model.gameEngine.GameConstants;
import model.sea.populate.*;

public class Sea {
	private int row;
    private int column;
    private Fish [][] sea ;
    private ArrayList<Fish> fishAlive;
        
    public Sea(GameConstants gc) {
    	
        this.row = gc.getSeaLenght();
        this.column = gc.getSeaWidth();
        
        this.sea = new Fish[column][row];
        this.fishAlive = new ArrayList<Fish>();
        
        populateSea(gc);
        
        for(int x = 0; x < this.column; x++) {
        	for(int y = 0; y < this.row; y++) {
        		if (sea[x][y] != null) {
        			this.fishAlive.add(sea[x][y]);
        		}
        	}
        }

    }
    
    private void populateSea(GameConstants gc) {
    	
    	int seaSize = this.row * this.column;
    	int fishNb = gc.getSeaSharkNumber() + gc.getSeaSardineNumber();
    	float populationRate = fishNb / seaSize;
    	
    	IStrategyPopulate strategy;
    	if (populationRate > 0 && populationRate <= 0.2) {
    		System.out.println("randomStrategy on");
    		strategy = new RandomStrategy();
    	} else if (populationRate > 0.2 && populationRate <= 0.4) {
    		System.out.println("free celle random strategy on");
    		strategy = new FreeCellRandom();
    	} else {
    		System.out.println("permutation random strategy on");
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
	
	public void moveFish(Fish fish, int x, int y) {
		this.sea[x][y] = this.sea[fish.getCoordinateX()][fish.getCoordinateY()];
		this.sea[fish.getCoordinateX()][fish.getCoordinateY()] = null;
		fish.setCoordinateX(x);
		fish.setCoordinateY(y);
	}
	
	public void deleteFish(Fish fish) {
		int x = fish.getCoordinateX();
		int y = fish.getCoordinateY();
		
		this.sea[x][y] = null;
		this.fishAlive.remove(fish);
	}
	
	public HashMap<String,Fish> getNeighborhood(Fish fish) {
		
		int x = fish.getCoordinateX();
		int y = fish.getCoordinateY();		
		HashMap<String,Fish> neighborhood = new HashMap<String,Fish>();
		
		//We store the possible neighbor in a hashMap. If there is no neighbor in a possible move, we don't add the move.
		if (x-1 >= 0) {
			neighborhood.put("LEFT", this.sea[x-1][y]);
			if (y-1 >= 0)
				neighborhood.put("DOWN_LEFT", this.sea[x-1][y-1]);
			if (y+1 <= this.row-1)
				neighborhood.put("TOP_LEFT", this.sea[x-1][y+1]);
		}
		
		if (x+1 <= this.column-1) {
			neighborhood.put("RIGHT", this.sea[x+1][y]);
			if (y-1 >= 0)
				neighborhood.put("DOWN_RIGHT", this.sea[x+1][y-1]);
			if (y+1 <= this.row-1)
				neighborhood.put("TOP_RIGHT", this.sea[x+1][y+1]);
		}
		
		if (y-1 >= 0)
			neighborhood.put("DOWN", this.sea[x][y-1]);
		if (y+1 <= this.row-1)
			neighborhood.put("TOP", this.sea[x][y+1]);
		
		return neighborhood;
		
	}

	public ArrayList<Fish> getFishAlive() {
		return fishAlive;
	}

	public void setFishAlive(ArrayList<Fish> fishAlive) {
		this.fishAlive = fishAlive;
	}
    
}
