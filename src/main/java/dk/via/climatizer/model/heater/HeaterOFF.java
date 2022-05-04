package dk.via.climatizer.model.heater;

public class HeaterOFF extends HeaterState {
	@Override public int getPowerLevel() {
		return 0;
	}

	@Override public HeaterState increaseState() {
		return new HeaterMIN();
	}

	@Override public HeaterState decreaseState() {
		throw new IllegalStateException("Heater already OFF");
	}
}
