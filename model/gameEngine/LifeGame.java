/**
 * A class for lauching the game and stop it when it's done
 * The game end when just one species or no species still alive
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.gameEngine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.fish.*;
import model.sea.*;

public class LifeGame {
	
	private Sea sea;
	private GameConstants gc;
	private int round;
	private boolean twoSpeciesALive;
	private String winnerSpecies;
	private String output;
	
	/**
     * Builds a new LifeGame
     */
	public LifeGame(GameConstants gameConstants) {
		this.gc = gameConstants;
		this.sea = new Sea(this.gc);
		this.round = 0;
		this.twoSpeciesALive = true;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		this.output = "Life game graphical output\nBy Pierre Labadille & Alexandre Ducreux\nJavaProject- M2-DNR2i, Université de Caen Normandie\nLauch the "+dateFormat.format(date)+"\n\n";
	}
	
	/**
     * Method used to launch a quickGame 
     * Meaning we don't display every move in front, we just do the math and display a recap
     */
	public void quickRunGame() {
		String constantsError = this.checkConstantsErrors();
		if ( constantsError == null) {
			while(this.twoSpeciesALive) {
				if (this.checkIfTwoSpeciesAlive()) {
					this.output += this.sea.logOutput(this.round);
					System.out.println("\n===============================================\n");
					System.out.println("Lauching the cycle " + this.round);
					System.out.println("Still " + this.sea.getSharkAlive() + " shark alive and " + this.sea.getSardineAlive() + " sardine alive");
					System.out.println("\n===============================================\n");
					this.playRound();
				}
			}
			this.endGame();
		} else {
			System.out.println(constantsError);
		}
		
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
     * Method used to check if the gameConstants are coherent
     * @return <String> if an error occurs or null.
     */
	private String checkConstantsErrors() {
		if (this.gc.getSeaWidth() <= 1 || this.gc.getSeaLenght() <= 1){
			return "Fatal Constants Error: seaWidth and seaLenght have to be greater than 1.";
		}
		if (this.gc.getSeaWidth() * this.gc.getSeaLenght() <= this.gc.getSeaSardineNumber() + this.gc.getSeaSharkNumber()) {
			return "Fatal Constants Error: the sea is to small to contain the number or fish you ask for. You need to make the sea bigger or to lower the number of fish.";
		}
		if (this.gc.getSeaSardineNumber() == 0 || this.gc.getSeaSharkNumber() == 0) {
			return "Fatal Constants Error: the number of shark or sardine have to be greater than 0.";
		}
		if (this.gc.getSharkIsAdult() <= this.gc.getSharkIsTeenager()) {
			return "Fatal Constants Error: the value of sharkIsAdult have to be greater than sharkIsTeenager.";
		}
		if (this.gc.getSharkStarvingTime() < 1) {
			return "Fatal Constants Error: the sharkStarvingTime have to be greater than 1.";
		}
		return null;
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
				System.out.println("\n***********************************************\n");
				System.out.println("Start " + fish + " turn");
				System.out.println("\n***********************************************\n");
				fish.playRound(this.sea);
			}
			i++;
		} 
	}
	
	/**
     * Method used to end the game and display a recap
     */
	private void endGame() {
		int round = this.round -1;
		System.out.println("\n===============================================\n");
		System.out.println("\nEnd of the game\n");
		System.out.println("\n===============================================\n");
		System.out.println("The game ended in " + round + " game cycle");
		this.output += this.sea.logOutput(this.round);
		this.output += "\nThe game ended in " + round + " game cycle\n";
		if (this.winnerSpecies != null) {
			System.out.println("The species who survive is the  " + this.winnerSpecies + "!");
			this.output += "The species who survive is the  " + this.winnerSpecies + "!";
		} else {
			System.out.println("No species survive... They both die in the same cycle.");
			this.output += "No species survive... They both die in the same cycle.";
		}
		
		//Generate output:
		try {
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(this.output);
			writer.close();
		} catch(IOException e) {
			System.out.print(e);
		}
		
	}

}