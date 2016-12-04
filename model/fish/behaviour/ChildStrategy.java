package model.fish.behaviour;

public class ChildStrategy implements IStateBehaviour {
	
	public void doAction(Context context) {
		System.out.println("active strategy: ChildStrategy");
		context.setState(this);
	}
	
}