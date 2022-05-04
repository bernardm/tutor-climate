package dk.via.climatizer.model.heater.states;

public class HeaterMED extends State {
	@Override public int getPowerLevel() {
		return 2;
	}

	@Override public State increaseState() {
		return new HeaterMAX();
	}

	@Override public State decreaseState() {
		return new HeaterMIN();
	}
}
