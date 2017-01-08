/**
 * A class for lauching the game and stop it when it's done
 * The game end when just one species or no species still alive
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.gameEngine;

import java.util.ArrayList;

import model.fish.*;
import model.sea.*;

public class LifeGame {
	
	private Sea sea;
	private GameConstants gameConstants;
	private int round;
	private boolean twoSpeciesALive;
	private String winnerSpecies;
	
	public LifeGame() {
		this.gameConstants = new GameConstants();
		this.sea = new Sea(this.gameConstants);
		this.round = 0;
		this.twoSpeciesALive = true;
	}
	
	public void quickRunGame() {
		while(this.twoSpeciesALive) {
			if (this.checkIfTwoSpeciesAlive()) {
				this.playRound();
			}
		}
		this.endGame();
	}
	
	public void runGame() {
		while(this.twoSpeciesALive) {
			if (this.checkIfTwoSpeciesAlive()) {
				this.playRound();
			}
		}
		this.endGame();
	}
	
	private boolean checkIfTwoSpeciesAlive() {
		ArrayList<Fish> fishAlive = this.sea.getFishAlive();
		boolean sardineAlive = false;
		boolean sharkAlive = false;
		
		for (Fish fish : fishAlive) {
			if (fish instanceof Sardine && !sardineAlive) {
				sardineAlive = true;
			} else if (fish instanceof Shark && !sharkAlive) {
				sharkAlive = true;
			}
			//if at least one of each species is alive, we don't need to keep running the loop.
			if (sardineAlive && sharkAlive) {
				return true;
			}
		}
		this.winnerSpecies = sardineAlive ? "sardines" : sharkAlive ? "sharks" : null;
		this.twoSpeciesALive = false;
		return false;
	}

	private void playRound() {
		this.round++;
		
		ArrayList<Fish> fishAlive = this.sea.getFishAlive();
		for (Fish fish : fishAlive) {
			fish.playRound(this.sea);
		}
	}
	
	private void endGame() {
		System.out.println("The game ended in " + this.round + " game cycle");
		if (this.winnerSpecies != null) {
			System.out.println("The species who survive is the  " + this.winnerSpecies + "!");
		} else {
			System.out.println("No species survive... They both die in the same cycle.");
		}
		
	}

}