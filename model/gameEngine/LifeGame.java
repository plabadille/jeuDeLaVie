package model.gameEngine;

import java.util.ArrayList;

import model.sea.*;
import model.fish.*;

public class LifeGame {
	
	protected Sea sea;
	protected ArrayList<Fish> fish = new ArrayList<Fish>();
	//sea constants
	private static final int WIDTH = 70;
	private static final int LENGTH = 100;
	private static final int SARDINE = 20;
	private static final int SHARK = 6;
	//sardine cosntants
	private static final int deathAge = ;
	private static final int spawnAge = ;
	private static final int spawnRatio = ;
	
	int age, int spawnAge, int spawnRatio, int x, int y) {
		super(age, spawnAge, spawnRatio, x, y
	
	//shark constants
	
	public LifeGame() {
		
		this.sea = new Sea(WIDTH, LENGTH, SARDINE, SHARK);
		
		for(int i = 0; i < SARDINE; i++) {
			this.fish.add(new Sardine());
		}
		
		//créer les poissons
	}
	
}
