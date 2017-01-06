package model.sea.populate;

import model.fish.Fish;
import model.gameEngine.GameConstants;

public interface IStrategyPopulate {
	
	public Fish [][] populateSea(GameConstants gc, Fish [][] sea);
	
}