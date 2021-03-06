/**
 * A sea populating strategy used when the population rate is high
 * generate coordinate of Fish next to each other then mix them n time randomly
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.sea.populate;

import model.fish.Fish;
import model.fish.Sardine;
import model.fish.Shark;
import model.gameEngine.GameConstants;

public class PermutationRandom implements IStrategyPopulate {
	
	private Fish [][] populatedSea;
	private int xSize;
	private int ySize;
	private int x;
	private int y;
	
	public Fish [][] populateSea(GameConstants gc, Fish [][] sea) {
		
		this.xSize = gc.getSeaLenght()-1;
		this.ySize = gc.getSeaWidth()-1;
		this.x = 0;
		this.y = 0;
		this.populatedSea = sea;
		Shark shark;
		Sardine sardine;
		
		//first we store each fish next to each other
		for (int i = 0; i < gc.getSeaSharkNumber(); i++) {
			shark = new Shark(gc, this.x, this.y);
			this.populatedSea[this.x][this.y] = shark;
			refreshCoordinate();
		}
		
		for (int i = 0; i < gc.getSeaSardineNumber(); i++) {
			sardine = new Sardine(gc, this.x, this.y);
			this.populatedSea[this.x][this.y] = sardine;
			refreshCoordinate();
		}
		
		//then we mix them by multiple permutation
		int x1;
		int x2;
		int y1;
		int y2;
		Fish tmp;
		
		for(int x = 0; x < this.xSize; x++) {
        	for(int y = 0; y < this.ySize; y++) {
        		
        		x1 = (int) (Math.random()*this.xSize);
                x2 = (int) (Math.random()*this.xSize);
                y1 = (int) (Math.random()*this.ySize);
                y2 = (int) (Math.random()*this.ySize);
                
                //we refresh the coordinate if a fish is permuted
                if (this.populatedSea[x1][y1] != null) {
                	this.populatedSea[x1][y1].setCoordinateX(x2);
                	this.populatedSea[x1][y1].setCoordinateX(y2);
                }
                if (this.populatedSea[x2][y2] != null) {
                	this.populatedSea[x2][y2].setCoordinateX(x1);
                	this.populatedSea[x2][y2].setCoordinateX(y1);
                }
                
                //we permute the slot in the sea
                tmp = this.populatedSea[x1][y1];
                this.populatedSea[x1][y1] = this.populatedSea[x2][y2];
                this.populatedSea[x2][y2] = tmp;
                  
        	}
        }
		
		return this.populatedSea;
		
	}
	
	/**
     * Method used to update coordinate for each Fish before the random (when they are assign next to each other)
     * Used because there's two type of Fish and to coordinate the line changement.
     */
	private void refreshCoordinate() {
		
		if (this.y == this.ySize) {
			this.x++;
			this.y = 0;
		} else {
			this.y++;
		}
		
	}

}