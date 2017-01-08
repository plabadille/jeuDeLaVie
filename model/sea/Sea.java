/**
 * A class for representing a sea: build with slot x and y and populated with Sharks and Sardines
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

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
    
    /**
     * Builds a new populated sea.
     * Use by LifeGame when a new game is launched.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
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
    
    /**
     * Populate a sea with Sharks and Sardines randomly by using some Game Constants.
     * It use a Strategy design pattern to choose the best way to populate the sea depending on population rate.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
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
    
    /**
     * Return the Sea (getter)
     * @return sea <Fish[][]> containing 2d Fish Array containing Sharks, Sardines or null.
     * @deprecated use getFishAlive() or getNeighborhood() instead
     */
	public Fish[][] getSea() {
		return sea;
	}
	
	/**
     * Set the Sea (setter)
     * @param sea <Fish[][]> 2d Fish Array containing Sharks, Sardines or null.
     * @deprecated use moveFish(),deleteFish(), createSardine(), createShark() instead
     */
	public void setSea(Fish[][] sea) {
		this.sea = sea;
	}
	
	/**
     * Method used to move a fish from a slot to an other.
     * Should be used by Fish method move()
     * @param fish <Fish> instance of Fish to move
     * @param x <int> new x coordinate for the Fish (column)
     * @param y <int> new y coordinate for the Fish (row)
     */
	public void moveFish(Fish fish, int x, int y) {
		this.sea[x][y] = this.sea[fish.getCoordinateX()][fish.getCoordinateY()];
		this.sea[fish.getCoordinateX()][fish.getCoordinateY()] = null;
		fish.setCoordinateX(x);
		fish.setCoordinateY(y);
	}
	
	/**
     * Method used to delete a fish from the game.
     * Should be used by Fish method eat() or dead()
     * @param fish <Fish> instance of Fish to remove from the game
     */
	public void deleteFish(Fish fish) {
		int x = fish.getCoordinateX();
		int y = fish.getCoordinateY();
		
		this.sea[x][y] = null;
		this.fishAlive.remove(fish);
	}
	
	/**
     * Method used to create a new Sardine in the sea
     * Should be used by Fish method giveBirth()
     * @param x <int> x coordinate for the new Fish (column)
     * @param y <int> y coordinate for the new Fish (row)
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
	public void createSardine(int x, int y, GameConstants gc) {
		Sardine sardine = new Sardine(gc, x, y);
		this.sea[x][y] = sardine;
		this.fishAlive.add(sardine);
	}
	
	/**
     * Method used to create a new Shark in the sea
     * Should be used by Fish method giveBirth()
     * @param x <int> x coordinate for the new Fish (column)
     * @param y <int> y coordinate for the new Fish (row)
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
	public void createShark(int x, int y, GameConstants gc) {
		Shark shark = new Shark(gc, x, y);
		this.sea[x][y] = shark;
		this.fishAlive.add(shark);
	}
	
	/**
     * Method used to get every possible adjacent slot of a Fish
     * The key contain possible Direction and the value contain what contain the slot
     * Should be used before doing moving a fish
     * @param fish <Fish> instance of Fish to get neighborhood
     * @return neighborhood <HashMap<Direction,Fish>> HashMap with neighborhood of a Fish
     */
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
	
	/**
     * Method used to get every instance of Fish alive (getter)
     * Should be used by sharks hunting strategy and by lifeGame to launch a new cycle
     * @return fishAlive <ArrayList<Fish>> ArrayList containing every instance of alive Fish
     */
	public ArrayList<Fish> getFishAlive() {
		return fishAlive;
	}
	
	/**
     * Method used to set every Fish alive (setter)
     * @param fishAlive <ArrayList<Fish>> ArrayList containing every instance of alive Fish
     * @deprecated use deleteFish() instead. The constructor already set this array and there's no reason to still use this.
     */
	public void setFishAlive(ArrayList<Fish> fishAlive) {
		this.fishAlive = fishAlive;
	}
    
}
