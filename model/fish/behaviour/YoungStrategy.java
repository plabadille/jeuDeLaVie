package model.fish.behaviour;

import model.gameEngine.GameConstants;

public class YoungStrategy implements IStateBehaviour {
	
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	public YoungStrategy(GameConstants gc) {
		this.gameConstants = gc;
		this.callNumber = this.gameConstants.getSharkIsYoung();
	}
	
	public void move(Context context) {
		//to do
		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsAdult()) {
			context.setState(new AdultStrategy());
		}
	}
	
}