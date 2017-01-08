/**
 * A sea populating strategy used when the population rate is low
 * generate the coordinate by randomly choose a cell. If the cell choosen is already taken it take the one next to it.
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2016-12-01
 */

package model.sea.populate;

public class RandomStrategy extends AbstractPopulateStrategy {
	
	protected void generateCoordinate() {
		
		int x = (int) (Math.random() * this.populatedSea.length);
		int y = (int) (Math.random() * this.populatedSea[x].length);
		
		//If a Fish is already in, we take the next one until we find empty coordinate.
		while (this.populatedSea[x][y] != null) {
			if (y < this.populatedSea[x].length) {
				y++;
			} else {
				if (x < this.populatedSea.length) {
					y = 0;
					x++;
				} else {
					x = 0;
					y = 0;
				}
			}
		}
		
		this.x = x;
		this.y = y;
	}
	
}