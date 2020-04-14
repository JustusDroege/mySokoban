public class TargetLocation extends Figures {
	
	private boolean isAchieved = false;

	TargetLocation(Position position) {
		super(position, '.');
	}

	public boolean isAchieved() {
		return isAchieved;
	}

	public void setAchieved(boolean isAchieved) {
		this.isAchieved = isAchieved;
	}
}
