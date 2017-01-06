package model.sea.populate;

import model.fish.Fish;
import model.gameEngine.GameConstants;

public class Context {
	
	private IStrategyPopulate strategy;
	
	public Context(IStrategyPopulate strategy) {
		this.strategy = strategy;
	}
	
	public Fish [][] executeStrategy(GameConstants gc, Fish [][] sea) {
		return strategy.populateSea(gc, sea);
	}
	
}
