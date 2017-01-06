package model.sea.populate;

import java.util.ArrayList;

public class FreeCellRandom extends AbstractPopulateStrategy {
	
	private ArrayList<ArrayList<Integer>> availableCoordinate = new ArrayList<ArrayList<Integer>>();
	
	protected void generateCoordinate()  {
		
		//At the first call we create the row of the list of list
		if (this.availableCoordinate.isEmpty()) {
			for (int x = 0; x < this.populatedSea.length; x++) {
				this.availableCoordinate.add(new ArrayList<Integer>());
			}
		}
		
		//when coordinate are empty, we store them if they're not already store
		for (int x = 0; x < this.populatedSea.length; x++) {
        	for (int y = 0; y < this.populatedSea[x].length; y++) {
        		if (populatedSea[x][y] == null)
        			if (!this.availableCoordinate.get(x).contains(y))
        				this.availableCoordinate.get(x).add(y);
        	}
		}
		
		//we do the random:
		int x = (int) (Math.random() * this.populatedSea.length);
		while (!this.availableCoordinate.get(x).isEmpty()) { //just in case every slot of a column are already taken
			x = (int) (Math.random() * this.populatedSea.length);
		}
		int y = (int) (Math.random() * this.availableCoordinate.get(x).size());
		
		//Then we remove the coordinate from the array and set the attr
		this.availableCoordinate.get(x).remove(y);
		this.x = x;
		this.y = this.availableCoordinate.get(x).get(y); //otherwise we will got the index and not the value.

	}
	
}