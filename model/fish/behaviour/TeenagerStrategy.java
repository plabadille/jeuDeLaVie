/**
 * A State for a Teenagers Sharks
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;

import java.util.HashMap;

import model.fish.Direction;
import model.fish.*;
import model.fish.Shark;

public class TeenagerStrategy implements IStateBehaviour {
	
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	/**
     * Construct the Teenager State
     * Dynamically change State to Adult when the age is reached
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
	public TeenagerStrategy(GameConstants gc) {
		this.gameConstants = gc;
		this.callNumber = this.gameConstants.getSharkIsTeenager();
	}
	
	public void move(Context context, Sea sea, Shark shark) {

		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsAdult()) {
			context.setState(new AdultStrategy());
			System.out.println("This Shark is now a Adult Sharks, he's " + this.callNumber + "years old");
		}
		
		Fish sardineToEat = null;
		
		HashMap<Direction,Fish> neighborhood = sea.getNeighborhood(shark);
		for(HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
		    Fish value = entry.getValue();
		    
		    if (value instanceof Sardine) {
		    	sardineToEat = value;
		    	break;
		    }
		}
		
		if (sardineToEat != null) { //we're next to a sardine, we eat it.
			int xSardine = sardineToEat.getCoordinateX();
			int ySardine = sardineToEat.getCoordinateY();
			shark.eat(sardineToEat, sea);
			sea.moveFish(shark, xSardine, ySardine);
		} else { //no sardine around, we do a random available move
			shark.randomMove(sea);
		}
	}
	
}