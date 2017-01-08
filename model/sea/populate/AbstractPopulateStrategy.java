/**
 * An abstract class for some populate strategy
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2017-01-06
 */


package model.sea.populate;

import model.fish.Fish;
import model.fish.Sardine;
import model.fish.Shark;
import model.gameEngine.GameConstants;

public abstract class AbstractPopulateStrategy implements IStrategyPopulate {

	protected int x;
	protected int y;
	protected Fish [][] populatedSea;
	
	public Fish [][] populateSea(GameConstants gc, Fish [][] sea) {
		
		this.populatedSea = sea;
		Shark shark;
		Sardine sardine;

		for (int i = 0; i < gc.getSeaSharkNumber(); i++) {
			generateCoordinate();
			
			shark = new Shark(gc, this.x, this.y);
			this.populatedSea[this.x][this.y] = shark;
		}
		
		for (int i = 0; i < gc.getSeaSardineNumber(); i++) {
			generateCoordinate();
			
			sardine = new Sardine(gc, this.x, this.y);
			this.populatedSea[this.x][this.y] = sardine;
		}
		
		return this.populatedSea;
		
	}
	
	/**
     * Method used to generateCoordinate randomly depending on the strategy used
     */
	protected abstract void generateCoordinate();
	
}
