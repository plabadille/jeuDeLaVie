/**
 * An interface to implements the design pattern State
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish.behaviour;

import model.sea.Sea;
import model.fish.Shark;

public interface IStateBehaviour {
	
	/**
     * Method used to execute the move depending on the State.
     * Child shark doesn't hunt so always go in a cell randomly
     * Teenager shark learn to hunt: if there is a cell with a Sardine next, it will choose it. Otherwise it's move is random.
     * Adult shark know how to hunt: they always do the best move in direction to the closest sardine.
     * @param context <Context> An instance containing the Context.
     * @param sea <Sea> An instance containing the Sea.
     * @param shark <Shark> An instance containing the shark to move
     */
	public void move(Context context, Sea sea, Shark shark);
	
}