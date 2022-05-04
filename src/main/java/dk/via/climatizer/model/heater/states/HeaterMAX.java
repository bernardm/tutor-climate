package dk.via.climatizer.model.heater.states;

public class HeaterMAX extends State {
	@Override public int getPowerLevel() {
		return 3;
	}

	@Override public State increaseState() {
		throw new IllegalStateException("Heater is already at maximum power");
	}

	@Override public State decreaseState() {
		return new HeaterMED();
	}
}
