/**
 * A State for a Adult Sharks
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.fish.behaviour;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.abs;

import model.fish.*;
import model.sea.Sea;

public class AdultStrategy implements IStateBehaviour {

	public void move(Context context, Sea sea, Shark shark) {
		
		//global init
		ArrayList<Fish> fishAlive = sea.getFishAlive();
		int x = shark.getCoordinateX();
		int y = shark.getCoordinateY();
		int xSardine;
		int ySardine;
		int roundToGetSardine;
		int closestRound = 9999;
		Fish closestSardine = null;
		
		//first we find the closest sardine
		for (Fish fish : fishAlive) {
			if (fish instanceof Sardine) {
				xSardine = fish.getCoordinateX();
				ySardine = fish.getCoordinateY();
				if (abs(x-xSardine) == abs(y-ySardine) || abs(x-xSardine) > abs(y-ySardine)) {
					roundToGetSardine = abs(x-xSardine);
				} else {
					roundToGetSardine = abs(y-ySardine);
				}
				if (roundToGetSardine < closestRound){
					closestSardine = fish;
					closestRound = roundToGetSardine;
					//if a sardine is near the shark we don't need to keep searching
					if (closestRound == 1)
						break;
				}
			}
		}
		
		//Second we find the best move to do to go to this sardine
		if (closestSardine != null){
			xSardine = closestSardine.getCoordinateX();
			ySardine = closestSardine.getCoordinateY();
			if (closestRound != 1) { //the sardine is not just near the shark
				HashMap<Direction,Fish> neighborhood = sea.getNeighborhood(shark);
				int dx;
				int dy;
				Direction optimalMove = null;
				closestRound = 9999;
				//We check all possibility to find the best and possible move
				for(HashMap.Entry<Direction, Fish> entry : neighborhood.entrySet()) {
				    Direction key = entry.getKey();
				    Fish value = entry.getValue();
				    
				    //we just need to check if the slot is empty (getNeighborhood just return possible move)
				    //we know there's no sardine next to us but we can't move in a slot where a Shark is already
				    if (value == null){
				    	dx = key.getDirectionX();
				    	dy = key.getDirectionY();
				    	
				    	if (abs(x+dx-xSardine) == abs(y+dy-ySardine) || abs(x+dx-xSardine) > abs(y+dy-ySardine)) {
							roundToGetSardine = abs(x+dx-xSardine);
						} else {
							roundToGetSardine = abs(y+dy-ySardine);
						}
				    	
				    	//if we find a closest sardine than before we update values
				    	if (roundToGetSardine < closestRound){ 
				    		optimalMove = key;
							closestRound = roundToGetSardine;
							//if a sardine is two round from the shark we stop, it's the best case
							if (closestRound == 2)
								break;
						}
				    }
				}
				
				if (optimalMove != null) {
					shark.starve();
					sea.moveFish(shark, x+optimalMove.getDirectionX(), y+optimalMove.getDirectionY());
				} else { //The shark is stuck between other sharks
					System.out.println("The Shark can't move because there's other sharks all around");
				}
			} else { //the sardine is one move close to the shark, we just have to eat it.
				shark.eat(closestSardine, sea);
				sea.moveFish(shark, xSardine, ySardine);
			}
		} else { //no more sardine, the game should end.
			System.out.println("no more Sardine or error in move() function of AdultShark");
		}
	}
	
}