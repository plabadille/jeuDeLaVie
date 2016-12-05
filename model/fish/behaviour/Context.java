package model.fish.behaviour;

import model.gameEngine.GameConstants;

public class Context {
	
	private IStateBehaviour state;
	private GameConstants gameConstants;

	   public Context(GameConstants gc){
		   this.gameConstants = gc;
		   setState(new ChildStrategy(this.gameConstants)); 
	   }

	   public void setState(IStateBehaviour state){
	      this.state = state;		
	   }

	   public IStateBehaviour getState(){
	      return this.state;
	   }
	   
	   public void move() {
		   this.state.move(this);
	   }
	   
}
