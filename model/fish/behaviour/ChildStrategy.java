/**
 * A State for a Child Sharks
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;
import model.fish.Shark;

public class ChildStrategy implements IStateBehaviour {
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	/**
     * Construct the Child State
     * Dynamically change State to Teenager when the age is reached
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
	public ChildStrategy(GameConstants gc) {
		this.callNumber = 0;
		this.gameConstants = gc;
	}
	
	public void move(Context context, Sea sea, Shark shark) {
		
		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsTeenager()) {
			context.setState(new TeenagerStrategy(this.gameConstants));
			System.out.println("This Shark is now a Teenager Sharks, he's " + this.callNumber + "years old");
		}
		
		shark.randomMove(sea);
		
	}
		
}