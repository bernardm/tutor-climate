package dk.via.climatizer.model.heater.states;

public abstract class State {
	public abstract int getPowerLevel();
	public abstract State increaseState();
	public abstract State decreaseState();
}
