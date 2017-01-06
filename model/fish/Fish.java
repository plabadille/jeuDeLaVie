package model.fish;

import model.gameEngine.GameConstants;

import model.sea.Sea;
import model.gameEngine.Direction;

public abstract class Fish {

    protected GameConstants gameConstants;
    protected int coordinateX;
    protected int coordinateY;
    protected int birth = 0;
    protected int[][] neighborsSquares;

    public Fish(GameConstants gc, int x, int y) {
        this.gameConstants = gc;
        this.coordinateX = x;
        this.coordinateY = y;

    }

    public abstract void dead();

    public abstract void move(Sea sea);

    /**
     * Method which consist of determined the neighbors squares
     *
     * @param sea
     * @return
     */
    public int[][] neighbourhood(Sea sea) {

        neighborsSquares = new int[8][8];
        int x = coordinateX;
        int y = coordinateY;
        int i = 0;
        for (Direction t : Direction.values()) {
            neighborsSquares[0][i] = x + t.getDirectionX();
            neighborsSquares[1][i] = y + t.getDirectionY();
            System.out.println("direction x :" + t.getDirectionX() + " Direction y :" + t.getDirectionY());
            i++;
        }
        //display possible coordinates to control
        for (int j = 0; j < neighborsSquares.length; j++) {
            System.out.println("coordonnées possible : x:" + neighborsSquares[0][j] + ",y:" + neighborsSquares[1][j]);
        }

        return neighborsSquares;
    }

    public boolean emptySquare(Sea sea) {

        //checkout empty coordinates
        for (int i=0; i<sea.getSea().length;i++) {
            for (int[] n : neighborsSquares) {
                if (sea.getSea()[coordinateX][coordinateY] != null) {
                    System.out.println("un poisson trouvé à la case : "+sea.getSea()[coordinateX][coordinateY]);
                    return true;
                }
                else{
                    System.out.println("pas de poisson trouvé à la case : "+sea.getSea()[coordinateX][coordinateY]);
                }
            }
        }
        System.out.println("aucun poisson trouvé...");
        return false;

    }
    
    public abstract int getCoordinateX();

    public abstract int getCoordinateY();

    public abstract void setCoordinateX(int coordinateX);

    public abstract void setCoordinateY(int coordinateY);
     

}
