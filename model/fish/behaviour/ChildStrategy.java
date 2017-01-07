package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;
import model.fish.Shark;

public class ChildStrategy implements IStateBehaviour {
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	public ChildStrategy(GameConstants gc) {
		this.callNumber = 0;
		this.gameConstants = gc;
	}
	
	public void move(Context context, Sea sea, Shark shark) {
		
		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsYoung()) {
			context.setState(new TeenagerStrategy(this.gameConstants));
		}
		
		shark.randomMove(sea);
		
	}
		
}