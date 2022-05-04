package dk.via.climatizer.model.heater.states;

public class HeaterOFF extends State {
	@Override public int getPowerLevel() {
		return 0;
	}

	@Override public State increaseState() {
		return new HeaterMIN();
	}

	@Override public State decreaseState() {
		throw new IllegalStateException("Heater already OFF");
	}
}
