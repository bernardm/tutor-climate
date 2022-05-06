package dk.via.climatizer.model.heater;

public class StateTimed extends State {
	private long timeMilis;

	public StateTimed(int seconds, Heater heater) {
		super(heater);
		this.timeMilis = (seconds * 1000L);
	}

	public void timeout() {
		heater.decreasePower();
	}

	@Override public void increasePower() {

	}

	@Override public void decreasePower() {
		heater.setState(new StateManual(heater));
		heater.powerLevel--;
	}
}
