package barreto.javier.climate.heater;

public class HeaterOFF implements HeaterState {
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
