package barreto.javier.climate.heater;

public class HeaterMED implements HeaterState {
	@Override public int getPowerLevel() {
		return 2;
	}

	@Override public HeaterState increaseState() {
		return new HeaterMAX();
	}

	@Override public HeaterState decreaseState() {
		return new HeaterMIN();
	}
}
