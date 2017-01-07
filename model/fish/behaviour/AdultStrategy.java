package model.fish.behaviour;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

import model.fish.*;
import model.sea.Sea;
//import model.gameEngine.GameConstants;

public class AdultStrategy implements IStateBehaviour {

	public void move(Context context, Sea sea, Shark shark) {
		
		//to do
		//no next step if it's an adult.
		ArrayList<Fish> fishAlive = sea.getFishAlive();
		int x = shark.getCoordinateX();
		int y = shark.getCoordinateY();
		int xSardine;
		int ySardine;
		Fish closestSardine = null;
		int roundToGetSardine;
		int closestRound = 9999;
		
		for (Fish fish : fishAlive) {
			if (fish instanceof Sardine) {
				xSardine = fish.getCoordinateX();
				ySardine = fish.getCoordinateY();
				if (abs(x-xSardine) == abs(y-ySardine) || abs(x-xSardine) > abs(y-ySardine)) {
					roundToGetSardine = abs(x-xSardine);
				} else {
					roundToGetSardine = abs(y-ySardine);
				}
				if (roundToGetSardine > closestRound){
					closestSardine = fish;
					closestRound = roundToGetSardine;
					//if a sardine is near the shark we don't need to continue
					if (closestRound == 1)
						break;
				}
			}
		}
		
		if (closestSardine != null){
			xSardine = closestSardine.getCoordinateX();
			ySardine = closestSardine.getCoordinateY();
			if (closestRound != 1) { //the sardine is not just near the shark
				
				HashMap<Direction,Fish> neighborhood = sea.getNeighborhood(shark);
				int dx;
				int dy;
				for(HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
				    Direction key = entry.getKey();
				    Fish value = entry.getValue();
				    
				    if (!(value instanceof Shark)){
				    	
				    }
				}
				
				
			} else { //the sardine is near the shark, we just got to eat it.
				//TO DO: delete below and call the eat function
				//TO DO Update boolean when sardine is eaten
				sea.deleteFish(closestSardine);
				sea.moveFish(shark, xSardine, ySardine);
			}
		} else { //no more sardine, the game should end.
			System.out.println("nor more Sardine or error in move() function of AdultShark");
		}
	}
	
}