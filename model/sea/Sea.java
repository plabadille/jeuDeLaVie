package model.sea;

import java.util.ArrayList;

import model.fish.*;
import model.gameEngine.GameConstants;

public class Sea {
    
	private int length;
    private int width;
    private Fish [][] sea ;
    private ArrayList<Fish> fishAlive;
        
    public Sea(GameConstants gc) {
    	
        this.length = gc.getSeaLenght();
        this.width = gc.getSeaWidth();
        
        this.sea = new Fish[width][length];
        this.fishAlive = new ArrayList<Fish>();
        
        for(int i = 0; i < gc.getSeaSharkNumber(); i++) {
        	//Need to create populate function, for first test we just populate on colon without random
        	Shark shark = new Shark(gc, 0, i);
        	this.sea[0][i] = shark;
        	this.fishAlive.add(shark);
        }
        
        for(int i = 0; i < gc.getSeaSardineNumber(); i++) {
        	//Need to create populate function, for first test we just populate on colon without random
        	Sardine sardine = new Sardine(gc, 1, i);
        	this.sea[1][i] = sardine;
        	this.fishAlive.add(sardine);
        	
        }
        
    }

	public Fish[][] getSea() {
		return sea;
	}

	public void setSea(Fish[][] sea) {
		this.sea = sea;
	}

	public ArrayList<Fish> getFishAlive() {
		return fishAlive;
	}

	public void setFishAlive(ArrayList<Fish> fishAlive) {
		this.fishAlive = fishAlive;
	}
	
	
    
}

