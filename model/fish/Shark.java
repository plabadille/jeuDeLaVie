package model.fish;

import model.gameEngine.GameConstants;

import java.util.ArrayList;
import java.util.HashMap;

import model.fish.behaviour.Context;
import model.sea.Sea;

public class Shark extends Fish 
{
    
    private Context context;
    private int starvingTime;
    
    public Shark(GameConstants gc, int x, int y) {
        super(gc, x, y);
        this.context = new Context(this.gameConstants);
        this.starvingTime = gc.getSharkStarvingTime();
    }
    
    protected void giveBirth(Sea sea) {
    	if (this.birth == gameConstants.getSharkSpawnAge()) {
    		int spawnRatio = gameConstants.getSharkSpawnRatio();
    		HashMap<Direction,Fish> neighborhood;
    		//We create n "babies" according to the spawnConstants
    		//Baby have to spawn in slot next to the mother. If there's none available, they don't spwan.
    		for (int i=0; i>spawnRatio; i++) {
    			neighborhood = sea.getNeighborhood(this);
    			for(HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
				    Direction key = entry.getKey();
				    Fish value = entry.getValue();
				    //If there is no free adjacency slot, the Shark doesn't give birth
				    if (value == null) {
				    	sea.createShark(this.getCoordinateX()+key.getDirectionX(), this.getCoordinateY()+key.getDirectionY(), gameConstants);
				    	break;
				    }
    			}
    		}
    	}
    }

    protected boolean dead(Sea sea) {
    	if (this.starvingTime < 0 || this.birth > gameConstants.getSharkDeathAge()) {
    		  sea.deleteFish(this);
    		  return false;
		}
    	return true;
    }

    protected void move(Sea sea) {
        this.context.move(sea, this);
    }
    
    //used by strategy of the pattern state in some case but in different strategy.
    public void randomMove(Sea sea) {
    	HashMap<Direction,Fish> neighborhood = sea.getNeighborhood(this);
    	ArrayList<Direction> directionRandomTable = new ArrayList<Direction>();
    	ArrayList<Fish> fishRandomTable = new ArrayList<Fish>();
    	
    	//first we check the possible move and store them into an array of Direction
    	for(HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
		    Direction key = entry.getKey();
		    Fish value = entry.getValue();
		    
		    if (!(value instanceof Shark)) {
		    	directionRandomTable.add(key);
		    	fishRandomTable.add(value);
		    }
    	}
    	
    	//second we select randomly one move
    	int random = (int) (Math.random()*directionRandomTable.size());
    	int x = directionRandomTable.get(random).getDirectionX();
    	int y = directionRandomTable.get(random).getDirectionY();
    	Fish fish = fishRandomTable.get(random);
    	
    	//then we check if there's something to eat and do the move.
    	if (fish == null) {
    		this.starve();
    		sea.moveFish(this, x, y);
    	} else {
    		this.eat(fish, sea);
    		sea.moveFish(this, x, y);
    	}	
    }
	
    //call by move() when the Shark eat
    public void eat(Fish sardine, Sea sea) {
    	if (sardine != null) {
    		this.starvingTime = gameConstants.getSharkStarvingTime();
        	sea.deleteFish(sardine);
    	}
    }
    //call by move() when the Shark doesn't eat
    public void starve() {
    	this.starvingTime--;
    }

}