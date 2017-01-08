/**
 * The class used by Sea to call a given strategy
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2017-01-06
 */

package model.sea.populate;

import model.fish.Fish;
import model.gameEngine.GameConstants;

public class Context {
	
	private IStrategyPopulate strategy;
	
	/**
     * Build an instance of Context containing the asked Strategy
     * @param strategy <IStrategyPopulate> An instance containing a Strategy
     */
	public Context(IStrategyPopulate strategy) {
		this.strategy = strategy;
	}
	
	/**
     * Method used to execute the populateStrategy of the Context build by construct.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     * @param sea <Fish [][]> A 2d array containing an empty sea
     */
	public Fish [][] executeStrategy(GameConstants gc, Fish [][] sea) {
		return strategy.populateSea(gc, sea);
	}
	
}
