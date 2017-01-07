/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fish;

/**
 *
 * @author alex2
 */
public enum Direction {
     //direction constants
    TOP(0,1),
    DOWN(0,-1),
    LEFT(-1,0),
    RIGHT(1,0),
    TOP_LEFT(-1,1),
    TOP_RIGHT(1,1),
    DOWN_LEFT(-1,-1),
    DOWN_RIGHT(1,-1);
    
    private int directionX;
    private int directionY;
    
    Direction(int directionX, int directionY){
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public static Direction getDOWN() {
        return DOWN;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }
    
    
}
