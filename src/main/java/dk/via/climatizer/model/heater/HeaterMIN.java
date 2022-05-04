package dk.via.climatizer.model.heater;

public class HeaterMIN extends HeaterState {
	@Override public int getPowerLevel() {
		return 1;
	}

	@Override public HeaterState increaseState() {
		return new HeaterMED();
	}

	@Override public HeaterState decreaseState() {
		return new HeaterOFF();
	}
}
