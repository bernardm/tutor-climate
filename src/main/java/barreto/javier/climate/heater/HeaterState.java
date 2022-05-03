package barreto.javier.climate.heater;

public interface HeaterState {
	int getPowerLevel();
	HeaterState increaseState();
	HeaterState decreaseState();
}
