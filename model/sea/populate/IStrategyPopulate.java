/**
 * An interface implements by every populateStrategy
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.sea.populate;

import model.fish.Fish;
import model.gameEngine.GameConstants;

public interface IStrategyPopulate {
	
	/**
     * Populate a given sea with Sharks and Sardines.
     * @param gc <GameConstants> An instance containing every Game Constants of the current game
     * @param sea <Fish [][]> 2d Fish array containing an empty sea
     */
	public Fish [][] populateSea(GameConstants gc, Fish [][] sea);
	
}