/**
 * The class used by Shark to choose it's moving (hunting) strategy depending on its state.
 * Always created by the Shark constructor.
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-04
 */

package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;
import model.fish.*;

public class Context {

	private IStateBehaviour state;
	private GameConstants gameConstants;
	
	/**
     * Build an instance of Context initialize at the Child State
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     */
	public Context(GameConstants gc) {
		this.gameConstants = gc;
		setState(new ChildStrategy(this.gameConstants));
	}
	
	/**
     * Setter use by the State to change State.
     * @param state <IStateBehaviour> The instance of the new State
     */
	public void setState(IStateBehaviour state) {
		this.state = state;
	}
	
	/**
     * Method used to execute the move depending on the State.
     * Child shark doesn't hunt so always go in a cell randomly
     * Teenager shark learn to hunt: if there is a cell with a Sardine next, it will choose it. Otherwise it's move is random.
     * Adult shark know how to hunt: they always do the best move in direction to the closest sardine. 
     * @param sea <Sea> An instance containing the Sea.
     * @param shark <Shark> An instance containing the shark to move
     */
	public void move(Sea sea, Shark shark) {
		this.state.move(this, sea, shark);
	}

}
