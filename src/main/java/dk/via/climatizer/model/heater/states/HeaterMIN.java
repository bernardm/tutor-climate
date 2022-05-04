package dk.via.climatizer.model.heater.states;

public class HeaterMIN extends State {
	@Override public int getPowerLevel() {
		return 1;
	}

	@Override public State increaseState() {
		return new HeaterMED();
	}

	@Override public State decreaseState() {
		return new HeaterOFF();
	}
}
