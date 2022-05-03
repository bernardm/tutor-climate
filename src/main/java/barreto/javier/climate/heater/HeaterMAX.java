package barreto.javier.climate.heater;

public class HeaterMAX implements HeaterState {
	@Override public int getPowerLevel() {
		return 3;
	}

	@Override public HeaterState increaseState() {
		throw new IllegalStateException("Heater is already at maximum power");
	}

	@Override public HeaterState decreaseState() {
		return new HeaterMED();
	}
}
