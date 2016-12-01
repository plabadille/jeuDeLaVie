package model.sea;

import model.fish.Fish;

public class Sea {
    
	private int length;
        private int width;
        private Fish [][] sea ;
        
        
        
    public Sea(int length, int width, int startSardineNumber, int startSharkNumber)
    {
        this.length = length;
        this.width = width;
        
        this.sea = new Fish[width][length];
        
    }

}

