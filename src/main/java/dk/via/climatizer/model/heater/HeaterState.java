package dk.via.climatizer.model.heater;

public abstract class HeaterState {
	public abstract int getPowerLevel();
	public abstract HeaterState increaseState();
	public abstract HeaterState decreaseState();
}
