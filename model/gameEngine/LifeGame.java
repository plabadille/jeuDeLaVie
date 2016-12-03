package model.gameEngine;

import java.util.ArrayList;

import model.fish.Fish;

import java.util.ArrayList;

import model.sea.*;
//import model.fish.*;

public class LifeGame {
	
	protected Sea sea;
//	protected ArrayList<Fish> fish = new ArrayList<Fish>();
	protected GameConstants gameConstants;
	protected int round;
	protected boolean twoSpecies;
	
	public LifeGame() {
		
		//init game:
		this.gameConstants = new GameConstants();
		this.sea = new Sea(this.gameConstants);
		this.round = 0;
		this.twoSpecies = true;
		
		//lanch the game:
		while(this.twoSpecies == true) {
			
			
			//check if no species alive
			ArrayList<Fish> fishAlive = sea.getFishAlive();
			if (fishAlive.isEmpty()) {
				this.twoSpecies = false;
			}
		}
		
	}
	
}
