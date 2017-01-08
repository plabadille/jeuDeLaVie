package controller;
/**
 * Class Observer
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

public class ButtonObserver {
	
	public void normalRun(String c) {
		//to do
		//should launch a main method in the gameEngine: LifeGameEvolve
		// --> normalRun is graphical run (round 1 by 1)
	}
	
	public void quickRun(String c) {
		//to do
		//should launch a alternative main method in the gameEngine
		// --> quickRun is non-graphic run (the program compute every round then show the result) 
	}
	
	public void exit(String c) {
		System.exit(0);
		
	}
	
}