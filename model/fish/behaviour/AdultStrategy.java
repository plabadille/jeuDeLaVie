package model.fish.behaviour;

public class AdultStrategy implements IStateBehaviour {
	
	public void doAction(Context context) {
		System.out.println("active strategy: AdultStrategy");
		context.setState(this);
	}
	
}