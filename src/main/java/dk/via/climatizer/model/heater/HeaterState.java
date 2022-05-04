package dk.via.climatizer.model.heater;

public interface HeaterState {
	int getPowerLevel();
	HeaterState increaseState();
	HeaterState decreaseState();
}
