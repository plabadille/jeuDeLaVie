
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
    	
        this.row = gc.getSeaWidth();
        this.column = gc.getSeaLenght();
        
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
    	
    	double seaSize = this.row * this.column;
    	double fishNb = gc.getSeaSharkNumber() + gc.getSeaSardineNumber();
    	double populationRate = fishNb / seaSize;
    	System.out.println("fishNb: " + fishNb + " . seaSize: " + seaSize);
    	System.out.println("populationRate: " + populationRate);
    	
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
	
	public void createSardine(int x, int y, GameConstants gc) {
		Sardine sardine = new Sardine(gc, x, y);
		this.sea[x][y] = sardine;
		this.fishAlive.add(sardine);
	}
	
	public void createShark(int x, int y, GameConstants gc) {
		Shark shark = new Shark(gc, x, y);
		this.sea[x][y] = shark;
		this.fishAlive.add(shark);
	}
	
	public HashMap<Direction,Fish> getNeighborhood(Fish fish) {
		
		int x = fish.getCoordinateX();
		int y = fish.getCoordinateY();		
		HashMap<Direction,Fish> neighborhood = new HashMap<Direction,Fish>();
		
		//We store the possible neighbor in a hashMap. If there is no neighbor in a possible move, we don't add the move.
		if (x-1 >= 0) {
			neighborhood.put(Direction.getLEFT(), this.sea[x-1][y]);
			if (y-1 >= 0)
				neighborhood.put(Direction.getDOWN_LEFT(), this.sea[x-1][y-1]);
			if (y+1 <= this.row-1)
				neighborhood.put(Direction.getTOP_LEFT(), this.sea[x-1][y+1]);
		}
		
		if (x+1 <= this.column-1) {
			neighborhood.put(Direction.getRIGHT(), this.sea[x+1][y]);
			if (y-1 >= 0)
				neighborhood.put(Direction.getDOWN_RIGHT(), this.sea[x+1][y-1]);
			if (y+1 <= this.row-1)
				neighborhood.put(Direction.getTOP_RIGHT(), this.sea[x+1][y+1]);
		}
		
		if (y-1 >= 0)
			neighborhood.put(Direction.getDOWN(), this.sea[x][y-1]);
		if (y+1 <= this.row-1)
			neighborhood.put(Direction.getTOP(), this.sea[x][y+1]);
		
		return neighborhood;
		
	}

	public ArrayList<Fish> getFishAlive() {
		return fishAlive;
	}

	public void setFishAlive(ArrayList<Fish> fishAlive) {
		this.fishAlive = fishAlive;
	}
    
}
