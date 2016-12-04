package model.fish.behaviour;

public class Context {
	
	private IStateBehaviour state;

	   public Context(){
	      state = null;
	   }

	   public void setState(IStateBehaviour state){
	      this.state = state;		
	   }

	   public IStateBehaviour getState(){
	      return state;
	   }
	   
}
