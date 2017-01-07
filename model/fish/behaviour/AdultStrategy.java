package model.fish.behaviour;

import java.util.ArrayList;

import model.fish.*;
import model.sea.Sea;

//import model.gameEngine.GameConstants;

public class AdultStrategy implements IStateBehaviour {
	
//	private int callNumber; //can be consider as the age of the fish
//	private GameConstants gameConstants;
//	
//	public AdultStrategy(GameConstants gc) {
//		this.gameConstants = gc;
//		this.callNumber = this.gameConstants.getSharkIsAdult();	
//	}
	
	public void move(Context context, Sea sea) {
		//to do
		//no next step if it's an adult.
		ArrayList<Fish> fishAlive = sea.getFishAlive();
		
	}
	
}