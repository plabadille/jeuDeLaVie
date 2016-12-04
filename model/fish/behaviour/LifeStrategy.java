package model.fish.behaviour;

public class LifeStrategy implements IStateBehaviour {
	
	public void doAction(Context context) {
		System.out.println("active strategy: LifeStrategy");
		context.setState(this);
	}
	
}