package model.fish.behaviour;

import model.sea.Sea;

public interface IStateBehaviour {
	
	public void move(Context context, Sea sea);
	
}