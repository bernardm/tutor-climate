package barreto.javier.climate.heater;

public class HeaterMIN implements HeaterState {
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
