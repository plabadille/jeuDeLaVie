/**
 * A sea populating strategy used when the population rate is medium
 * generate coordinate of Fish by first retrieving every available cell of the sea and then randomly choose a cell.
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.sea.populate;

import java.util.ArrayList;

public class FreeCellRandom extends AbstractPopulateStrategy {
	
	private ArrayList<ArrayList<Integer>> availableCoordinate = new ArrayList<ArrayList<Integer>>();
	
	protected void generateCoordinate()  {
		
		if (this.availableCoordinate.isEmpty()) {
			this.findEmptyCoordinate();
		}

		//we do the random:
		int x = (int) (Math.random() * this.availableCoordinate.size());
		int y = (int) (Math.random() * this.availableCoordinate.get(x).size());
		
		//Then we remove the coordinate from the array and set the attr
		this.x = x;
		this.y = this.availableCoordinate.get(x).get(y); //otherwise we will got the index and not the value.
		this.availableCoordinate.get(x).remove(y);

	}
	
	/**
     * Method used to store empty cells in this.availableCoordinate
     */
	private void findEmptyCoordinate() {
		//At the first call we create the row of the list of list
		for (int x = 0; x < this.populatedSea.length; x++) {
			this.availableCoordinate.add(new ArrayList<Integer>());
		}
		
		//when coordinate are empty, we store them if they're not already store
		for (int x = 0; x < this.populatedSea.length; x++) {
        	for (int y = 0; y < this.populatedSea[x].length; y++) {
        		if (populatedSea[x][y] == null)
        			if (!this.availableCoordinate.get(x).contains(y))
        				this.availableCoordinate.get(x).add(y);
        	}
		}
	}
	
}