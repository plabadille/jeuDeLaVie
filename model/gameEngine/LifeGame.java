package model.gameEngine;

import model.fish.*;
import model.sea.*;

public class LifeGame {
	
	protected Sea sea;
	protected GameConstants gameConstants;
	protected int round;
	
	public LifeGame() {
		this.gameConstants = new GameConstants();
		this.sea = new Sea(this.gameConstants);
		this.round = 0;
	}
	
	protected void runTime(int nr) {
		for (int i = 0; i < nr; i++) {
			playRound();
		}
	}
	
	protected void runTimeUntilNoSpeciesAlive() {
		boolean twoSpecies = true;
		while(twoSpecies) {
			playRound();
			
			//check if no species alive
			if (sea.getFishAlive().isEmpty()) {
				twoSpecies = false;
				break;
			}
		}
	}
	
	protected void runTimeUntilOneSpeciesAlive() {
		boolean twoSpecies = true;
		while(twoSpecies) {
			playRound();
			
			//check if only one species survive
			boolean sardineAlive = false;
			boolean sharkAlive = false;
			for(Fish fish : sea.getFishAlive()) {
				if (fish instanceof Sardine) {
					sardineAlive = true;
				}
				if (fish instanceof Shark) {
					sharkAlive = true;
				}
			}
			if (!sharkAlive || !sardineAlive) {
				twoSpecies = false;
				break;
			}
		}
	}
	
	protected void playRound() {
		this.round++;
		//to do
	}

}