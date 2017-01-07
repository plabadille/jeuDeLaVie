package model.fish.behaviour;

import model.sea.Sea;
import model.fish.Shark;

public interface IStateBehaviour {
	
	public void move(Context context, Sea sea, Shark shark);
	
}