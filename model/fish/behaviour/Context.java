package model.fish.behaviour;

import model.gameEngine.GameConstants;
import model.sea.Sea;
import model.fish.*;

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
	   
	   public void move(Sea sea, Shark shark) {
		   this.state.move(this, sea, shark);
	   }
	   
}
