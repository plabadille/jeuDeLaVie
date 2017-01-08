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
    private int sardineAlive;
    private int sharkAlive;
    
    /**
     * Builds a new populated sea.
     * Use by LifeGame when a new game is launched.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
    public Sea(GameConstants gc) {
    	System.out.println("\n===============================================\n");
    	System.out.println("Initialization");
    	System.out.println("\n===============================================\n");
        this.row = gc.getSeaWidth();
        this.column = gc.getSeaLenght();
        
        this.sea = new Fish[column][row];
        System.out.println("->The sea is create with x:[" + this.column + "], y:[" + this.row + "]");
        this.fishAlive = new ArrayList<Fish>();
        this.sardineAlive = gc.getSeaSardineNumber();
        this.sharkAlive = gc.getSeaSharkNumber();
        
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
    		System.out.println("random population strategy on");
    		strategy = new RandomStrategy();
    	} else if (populationRate > 0.2 && populationRate <= 0.4) {
    		System.out.println("free cells random population strategy on");
    		strategy = new FreeCellRandom();
    	} else {
    		System.out.println("permutation random population strategy on");
    		strategy = new PermutationRandom();
    	}
    	
    	Context context = new Context(strategy);
    	this.sea = context.executeStrategy(gc, this.sea);
    	System.out.println("->The sea has been populated with shark:[" + gc.getSeaSharkNumber() + "], sardine:[" + gc.getSeaSardineNumber() + "]");
    	
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
		System.out.println("" + fish + " move in coordinate: x[" + x + "], y[" + y + "]");
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
		if (fish instanceof Shark) {
			this.sharkAlive--;
		} else {
			this.sardineAlive--;
		}
		System.out.println("" + fish + " is dead");
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
		this.sardineAlive++;
		Sardine sardine = new Sardine(gc, x, y);
		System.out.println("" + sardine + " is born in coordinate: x[" + x + "], y[" + y + "]");
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
		this.sharkAlive++;
		Shark shark = new Shark(gc, x, y);
		System.out.println("" + shark + " is born in coordinate: x[" + x + "], y[" + y + "]");
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
    
	/**
     * Method used by LifeGame to iterate on the FishAlive attr.
     * This is require because this arrayList change so we can't iterate on it directly in LifeGame
     * @param index <int> index generated by a loop in LifeGame
     * @return fish <Fish> instance containing the fish witch is going to play is turn
     */
	public Fish getNextFishAlive(int index) {
		int maxIndex = this.fishAlive.size()-1;
		if (index <= maxIndex) {
			return this.fishAlive.get(index);
		}
		return null;
	}

	public int getSardineAlive() {
		return sardineAlive;
	}

	public int getSharkAlive() {
		return sharkAlive;
	}
}
