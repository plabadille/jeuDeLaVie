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
	
	/**
     * Builds a new LifeGame
     */
	public LifeGame() {
		this.gameConstants = new GameConstants();
		this.sea = new Sea(this.gameConstants);
		this.round = 0;
		this.twoSpeciesALive = true;
	}
	
	/**
     * Method used to launch a quickGame 
     * Meaning we don't display every move in front, we just do the math and display a recap
     */
	public void quickRunGame() {
		while(this.twoSpeciesALive) {
			if (this.checkIfTwoSpeciesAlive()) {
				this.playRound();
			}
		}
		this.endGame();
	}
	
	/**
     * Method used to launch a game with graphic display of each cycle
     */
	public void runGame() {
		//to change
		while(this.twoSpeciesALive) {
			if (this.checkIfTwoSpeciesAlive()) {
				this.playRound();
			}
		}
		this.endGame();
	}
	
	/**
     * Method used to check if both species still alive
     * @return <boolean> true if two species, false if just one left.
     */
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
	
	/**
     * Method used to play a new round on every alive fish
     */
	private void playRound() {
		this.round++;
		Fish fish = null;
		boolean keepLooping = true;
		int i = 0;
		while(keepLooping) {
			fish = this.sea.getNextFishAlive(i);
			if (fish == null) {
				keepLooping = false;
			} else {
				fish.playRound(this.sea);
			}
			i++;
		} 
		
	}
	
	/**
     * Method used to end the game and display a recap
     */
	private void endGame() {
		System.out.println("The game ended in " + this.round + " game cycle");
		if (this.winnerSpecies != null) {
			System.out.println("The species who survive is the  " + this.winnerSpecies + "!");
		} else {
			System.out.println("No species survive... They both die in the same cycle.");
		}
		
	}

}