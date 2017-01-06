package model.fish.behaviour;

import model.gameEngine.GameConstants;

public class ChildStrategy implements IStateBehaviour {
	private int callNumber; //can be consider as the age of the fish
	private GameConstants gameConstants;
	
	public ChildStrategy(GameConstants gc) {
		this.callNumber = 0;
		this.gameConstants = gc;
	}
	
	public void dead(Context context) {
		//to do
	}
	
	public void move(Context context) {
		//to do
		
		//The state change when the constants age is reached:
		if(++this.callNumber == this.gameConstants.getSharkIsYoung()) {
			context.setState(new TeenagerStrategy(this.gameConstants));
		}
		
	}
	
	public void eatSardine(Context context) {
		//to do
	}
	
}