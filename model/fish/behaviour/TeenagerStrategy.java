package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;

public class TeenagerStrategy implements IStateBehaviour {
	
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	public TeenagerStrategy(GameConstants gc) {
		this.gameConstants = gc;
		this.callNumber = this.gameConstants.getSharkIsYoung();
	}
	
	public void move(Context context, Sea sea) {
		//to do
		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsAdult()) {
			context.setState(new AdultStrategy());
		}
	}
	
}