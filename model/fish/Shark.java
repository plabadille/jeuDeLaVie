package model.fish;

public class Shark extends Fish {
    
    
    
    public Shark(int deadAge, int spawnAge, int spawnRatio, int x, int y)
    {
        super(deadAge, spawnAge, spawnRatio, x, y);
    }

    @Override
    public void dead() {
        
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    public void eatSardine()
    {
        //to do
    }
}